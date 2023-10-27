package racingcar;

import racingcar.Car.Car;
import racingcar.View.InputView;
import racingcar.Computer.RaceManager;
import java.util.List;


public class Race {
    private RaceManager raceManager;

    public void init() {
        List<Car> cars = InputView.promptCarNames();
        int repeatCount = InputView.promptNumber();
        raceManager = new RaceManager(cars, repeatCount);
    }

    public void play() {
        raceManager.startRace();
    }
}
