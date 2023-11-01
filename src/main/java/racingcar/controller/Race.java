package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveCount;
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

    private List<Car> findWinners() {
        int currentMaxPosition = cars.getCurrentPosition();
        return cars.findWinner(currentMaxPosition);
    }
}
