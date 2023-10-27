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

    public boolean init() {
        try {
            cars = InputView.promptCarNames();
            int repeatCount = InputView.promptNumber();
            raceManager = new RaceManager(cars, repeatCount);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
            return false;
        }
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
