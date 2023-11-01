package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final InputController inputController;
    private final int START_INCLUSIVE = 0;
    private final int END_INCLUSIVE = 9;
    private static final int FORWARD_CONDITION = 4;
    public Game(){
        this.inputController = new InputController();
    }

    public void initGame(){
        OutputView.askCarNameMessage();
        Cars cars = inputController.getCarNameFromUserInput();

        OutputView.askAttemptCount();;
        int attemptCount = inputController.getAttemptCountFromUserInput();

        match(cars, attemptCount);
    }

    public void match(Cars cars, int attemptCount) {
        OutputView.showHeadOfRoundResult();

        for (int round = 0; round < attemptCount; round++) {
            moveForwardByRandomNumber(cars);
            showRoundResult(cars);
        }

        OutputView.showGameWinner(getWinner(cars, getLeaderPosition(cars)));
    }

    public void moveForwardByRandomNumber(Cars cars) {
        for (Car car : cars.getCarList()) {
            if (getRandomNumber() >= FORWARD_CONDITION)
                car.moveForward();
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public void showRoundResult(Cars cars) {
        for (Car car : cars.getCarList()) {
            OutputView.showRoundResultByCar(car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public int getLeaderPosition(Cars cars) {
        int leaderPosition = 0;

        for (Car car : cars.getCarList()) {
            if (car.getPosition() > leaderPosition)
                leaderPosition = car.getPosition();
        }

        return leaderPosition;
    }

    public String getWinner(Cars cars, int leaderPosition) {
        List<Car> winnerList = cars.getCarList().stream()
                .filter(car -> car.getPosition() == leaderPosition).toList();

        return winnerList.stream().map(Car::getName).collect(Collectors.joining(", "));
    }
}
