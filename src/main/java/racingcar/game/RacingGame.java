package racingcar.game;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;

public final class RacingGame {
    private final RaceResult raceResult = new RaceResult();
    private Cars cars;

    public RacingGame() {
    }

    public void startGame() {
        InputProvider inputProvider = InputProvider.getInstance();
        String names = inputProvider.receiveCarNames();
        int raceCount = inputProvider.receiveRaceCount();

        cars = Cars.getCarsFromNames(names);

        playGame(raceCount);
    }

    private void playGame(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars = cars.race();
            System.out.println(raceResult.getRaceProgress(cars.carList()));
        }
        List<Car> winnerList = cars.findWinners();
        System.out.println(raceResult.getWinners(winnerList));
    }
}
