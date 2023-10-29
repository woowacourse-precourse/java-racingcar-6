package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RaceResultDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private Car car;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        car = new Car(askCarNames());
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
        for (int raceCount = 0; raceCount < numberOfRaces; raceCount++) {
            RaceResultDTO raceResultDTO = car.oneCarRace();
            outputView.printRaceResult(raceResultDTO);
        }
        outputView.printWinners(car.getWinners());
    }
}