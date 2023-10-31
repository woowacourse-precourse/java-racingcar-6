package racingcar;

import racingcar.Car.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.Computer.RaceManager;
import java.util.List;
import racingcar.Computer.DetermineWinner;

public class Race {
    private RaceManager raceManager;
    private List<Car> cars;
    private final DetermineWinner determineWinner = new DetermineWinner();

    public void init() {
        cars = InputView.promptCarNames();
        int repeatCount = InputView.promptNumber();
        raceManager = new RaceManager(cars, repeatCount);
    }

    public void play() {
        raceManager.startRace();
        printWinners();
        Runtime.getRuntime().exit(0);
    }

    private void printWinners() {
        List<Car> winners = determineWinner.getWinners(cars);
        OutputView.printWinners(winners);
    }
}
