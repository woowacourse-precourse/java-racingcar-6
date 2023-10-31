package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class Race {

    private final Cars cars;
    private int moveCnt;

    public Race(Cars cars, int moveCnt) {
        this.cars = cars;
        this.moveCnt = moveCnt;
    }

    public void run() {
        OutputView.printResult();
        while (moveCnt > 0) {
            cars.playSingleTurn();
            OutputView.printCarsMove(cars.carsInformation());
            moveCnt--;
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

