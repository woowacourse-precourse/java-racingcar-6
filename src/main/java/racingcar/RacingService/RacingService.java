package racingcar.RacingService;

import racingcar.model.Car;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static racingcar.model.RacingRule.isOkToUseAttemptCount;
import static racingcar.model.RacingRule.isOkToUseCarName;
import static racingcar.view.InputView.getAttemptCountFromUser;
import static racingcar.view.InputView.getCarNamesFromUser;
import static racingcar.view.OutputView.*;

public class RacingService {
    private List<Car> cars;
    private List<String> carNameList;
    private int totalRounds;

    public void readyCarName() {
        displayCarNamePrompt();

        List<String> cadidateNameList = getCarNameList();

        if(validateCarNameList(cadidateNameList)) {
            carNameList = cadidateNameList;
        }
    }

    protected List<String> getCarNameList() {
        String carNames = getCarNamesFromUser();

        List<String> carNameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .collect(toList());

        return carNameList;
    }

    protected boolean validateCarNameList(List<String> carNameList) {
        for(String carName : carNameList){
            isOkToUseCarName(carName);
        }

        return true;
    }

    public void readyAttemptCount() {
        displayAttemptPrompt();
        totalRounds = getAttemptCount();
    }

    protected int getAttemptCount() {
        int attemptCountFromUser = getAttemptCountFromUser();

        isOkToUseAttemptCount(attemptCountFromUser);

        return attemptCountFromUser;
    }

    public void readyCars(NumberGenerator numberGenerator) {
        cars = new ArrayList<>();
        for(String carName : carNameList) {
            cars.add(new Car(carName, numberGenerator));
        }
    }

    // test를 위한 getter
    protected List<Car> getCars() {
        return cars;
    }

    // controller에 책임을 주기 위한 getter
    public int getTotalRounds() {
        return totalRounds;
    }

    public void playOneRound() {
        for (Car car : cars) {
            car.move();
            displayCurrentGameResult(car.getName(), convertPositionToDashes(car));
        }
    }

    private String convertPositionToDashes(Car car) {
        return "-".repeat(car.getPosition());
    }

    public void announceWinner() {
        displayWinner(findWinner(cars));
    }

    protected String findWinner(List<Car> cars) {
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
}
