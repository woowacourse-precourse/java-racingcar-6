package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.BadInputException;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private final List<Car> finalWinners = new ArrayList<>();
    private int attemptCount;

    public void start() {
        registerCars();
        inputAttemptCount();

        play();
    }

    private void registerCars() {
        String carNames = InputView.carNames();
        String[] names = checkValid(carNames);
        for (String name : names) {
            addCar(name);
        }
    }

    private String[] checkValid(String carNames) {
        String[] names = carNames.split(",");

        BadInputException.checkMinimumParticipants(names);
        trimSpaces(names); // 양끝 공백 제거
        BadInputException.isNameDuplicate(names);

        for (String name : names) {
            BadInputException.isSpace(name); // 이름에 공백이 포함되어 있는지 확인
            BadInputException.checkNameLength(name);
        }

        return names;
    }

    public void trimSpaces(String[] names) {
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
    }

    private void addCar(String name) {
        Car car = new Car(name);
        carList.add(car);
    }

    private void inputAttemptCount() {
        String count = InputView.attemptCount();

        checkNaturalNumber(count);

        setAttemptCount(Integer.parseInt(count));
    }

    private void checkNaturalNumber(String count) {
        BadInputException.checkNumber(count);
        BadInputException.isPositiveNum(Integer.parseInt(count));
    }

    private void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public void play() {
        OutputView.exeutionResult();
        for (int i = 0; i < attemptCount; i++) {
            Round.play(carList);
        }

        decideWinner();
        OutputView.finalWinner(finalWinners);
    }

    private void decideWinner() {
        int maxPosition = -1;

        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                finalWinners.clear();
                finalWinners.add(car);
            } else if (car.getPosition() == maxPosition) {
                finalWinners.add(car);
            }
        }
    }
}
