package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RaceResultDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        cars = new Cars(askCarNames());
        carRace(askNumberOfRaces());
    }

    private List<String> askCarNames() {
        return inputView.readNames();
    }

    private int askNumberOfRaces() {
        return inputView.readNumberOfRaces();
    }

    private void carRace(int numberOfRaces) {
        outputView.printResultMessage();
        runRace(numberOfRaces);
        printWinners();
    }

    private void runRace(int numberOfRaces) {
        while (hasMoreRaces(numberOfRaces--)) {
            carRacing.oneRacing();
            printRacingResult();
        }
    }

    private boolean hasMoreRaces(int numberOfRaces) {
        return numberOfRaces > 0;
    }

    private void printRacingResult() {
        RacingResultDTO racingResultDTO = carRacing.toDTO();
        outputView.printRacingResult(racingResultDTO);
    }

    private void printWinners() {
        outputView.printWinners(carRacing.getWinners());
    }
}