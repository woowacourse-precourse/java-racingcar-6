package racingcar.service;

import java.util.Collections;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class RacingGameService {

    private RacingGame racingGame;

    public void initializeGameInfo(List<String> carNames, int gameCount) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        racingGame = new RacingGame(cars, gameCount);
    }

    public boolean finishGame() {
        return racingGame.getCurrentGameCount() == racingGame.getGameCount();
    }

    public void tryGame() {
        racingGame.addCurrentGameCount();
        List<Car> cars = racingGame.getCars();
        cars.forEach(car -> racingGame.decideCarProgress(car));
    }

    public List<Car> getResult() {
        return racingGame.getCars();
    }

    public List<Car> getWinners() {
        List<Car> cars = racingGame.getCars();
        List<Integer> progress = cars.stream()
                .map(Car::getProgress)
                .toList();
        int max = Collections.max(progress);
        return cars.stream().filter(car -> car.getProgress() == max).toList();
    }
}
