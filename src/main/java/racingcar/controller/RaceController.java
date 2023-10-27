package racingcar.controller;

import static java.util.stream.Collectors.joining;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.TryRemains;
import racingcar.service.CarMover;
import racingcar.service.WinnerChecker;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

public class RaceController {
    TryRemains tryRemains;
    List<Car> carList;

    public RaceController(List<Car> carList) {
        this.carList = carList;
        createTryRemains(InputHandler.inputNumberOfTry());
        OutputHandler.printRaceProgressLabel();
        doTry();
        printFinalWinner();
    }

    private void doTry() {
        if (tryRemains.isZero()) {
            return;
        }
        tryRemains.doTry();
        CarMover.move(carList);
        printRaceProgress();
        doTry();
    }

    private void printRaceProgress() {
        OutputHandler.printRaceProgress(carList.stream()
                        .map(Car::getNameToString)
                        .toList(),
                carList.stream()
                        .map(Car::getProgressToInt)
                        .toList());
    }

    private void printFinalWinner() {
        List<Car> winnerList = WinnerChecker.findWinner(carList);
        OutputHandler.printFinalWinner(winnerList.stream()
                .map(Car::getNameToString)
                .collect(joining(", ")));
    }

    private void createTryRemains(String userInput) {
        tryRemains = new TryRemains(Integer.parseInt(userInput));
    }
}
