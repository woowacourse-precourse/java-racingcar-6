package racingcar.controller;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.NumberOfTry;
import racingcar.service.CarMover;
import racingcar.service.RaceProgessStringAssembler;
import racingcar.service.WinnerChecker;
import racingcar.verifier.InputVerifier;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

public class RaceController {
    private final List<Car> carList;
    private NumberOfTry numberOfTry;

    public RaceController(List<Car> carList) {
        this.carList = carList;
        createTryRemains(InputHandler.inputNumberOfTry());
        OutputHandler.printRaceProgressLabel();
        doTry();
        printFinalWinner();
    }

    private void doTry() {
        IntStream.range(0, numberOfTry.getValue())
                .forEach(i -> {
                    CarMover.move(carList);
                    printRaceProgress();
                });
    }

    private void printRaceProgress() {
        OutputHandler.printRaceProgress(carList.stream()
                .map(RaceProgessStringAssembler::assembleRaceProgress)
                .toList());
    }

    private void printFinalWinner() {
        OutputHandler.printFinalWinner(WinnerChecker.findWinner(carList).stream()
                .map(Car::getNameToString)
                .collect(joining(", ")));
    }

    private void createTryRemains(String userInput) {
        InputVerifier.verifyTry(userInput);
        numberOfTry = new NumberOfTry(Integer.parseInt(userInput));
    }
}
