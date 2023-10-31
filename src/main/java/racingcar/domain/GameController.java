package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public void playGame() {
        InputCarName inputCarName = new InputCarName();
        InputNumberOfAttempts inputNumberOfAttempts = new InputNumberOfAttempts();
        RaceResultsPresenter raceResultsPresenter = new RaceResultsPresenter();

        List<String> carNames = inputCarName.getCarNames();
        List<Car> cars = inputCarName.createCarsFromCarNames(carNames);
        int numberOfAttempts = inputNumberOfAttempts.getNumberOfAttempts();

        do {
            for (Car car : cars){
                car.move();
            }
            raceResultsPresenter.printRaceProcess(cars);
        }
        while (numberOfAttempts-- != 0);

        raceResultsPresenter.printWinner();
    }
}
