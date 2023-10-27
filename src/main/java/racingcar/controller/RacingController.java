package racingcar.controller;


import racingcar.model.Car;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;
import static racingcar.model.GameRule.isOkToUseAttemptCount;
import static racingcar.model.GameRule.isOkToUseCarName;
import static racingcar.view.InputView.getAttemptCountFromUser;
import static racingcar.view.InputView.getCarNamesFromUser;
import static racingcar.view.OutputView.*;

public class RacingController {

    private List<Car> cars;
    private int totalRounds;
    private List<String> carNameList;

    public RacingController() {
        initializeGame();
    }

    private void initializeGame() {
        carNameList = getCarNames();
        totalRounds = getAttemptCount();

        registerCars();

        displayGameStartMessage();
    }

    private void registerCars() {
        cars = new ArrayList<>();
        for(String carName : carNameList) {
            cars.add(new Car(carName, new RandomNumberGenerator()));
        }
    }

    private List<String> getCarNames() {
        displayCarNamePrompt();
        String carNames = getCarNamesFromUser();
        List<String> carNameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .collect(toList());

        for(String carName : carNameList){
            if(!isOkToUseCarName(carName)) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다!");
            }
        }
        return carNameList;
    }

    private int getAttemptCount() {
        displayAttemptPrompt();
        int attemptCountFromUser = getAttemptCountFromUser();

        if(!isOkToUseAttemptCount(attemptCountFromUser)){
            throw new IllegalArgumentException("올바른 시도 횟수를 입력하지 않았습니다!");
        }
        return attemptCountFromUser;
    }

    public void run() {
        while(gameContinue()) {
            playOneRound();
            displayFinishOnce();
        }
        displayWinner(findWinner(cars));
    }

    private void playOneRound() {
        for (Car car : cars) {
            car.move();
            displayCurrentGameResult(car.getName(), convertPositionToDashes(car));
        }
    }

    private String findWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(joining(", "));
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private String convertPositionToDashes(Car car) {
        return "-".repeat(car.getPosition());
    }

    private boolean gameContinue() {
        return totalRounds-- > 0;
    }
}
