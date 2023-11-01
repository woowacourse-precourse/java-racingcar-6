package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveCount;
import racingcar.utils.ErrorMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private final Cars cars;

    private final MoveCount moveCnt;

    public Race(Cars cars, MoveCount moveCnt) {
        this.cars = cars;
        this.moveCnt = moveCnt;
    }

    public void run() {
        OutputView.printResult();
        while (moveCnt.isOn()) {
            cars.playSingleTurn();
            OutputView.printCarsMove(cars.carsInformation());
            moveCnt.next();
        }
        List<String> winnerNames = findWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        OutputView.printFindWinner(winnerNames);
    }

    public static MoveCount inputMoveCount() {
        try {
            MoveCount moveCount = new MoveCount(Integer.parseInt(InputView.userInput()));
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
        }
    }

    private List<Car> findWinners() {
        int currentMaxPosition = cars.getCurrentPosition();
        return cars.findWinner(currentMaxPosition);
    }
}
