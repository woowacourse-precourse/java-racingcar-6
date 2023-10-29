package racingcar;

import java.util.List;

public final class RacingGame {
    private static final RacingGame racingGame = new RacingGame();
    private final RaceResult raceResult = new RaceResult();
    private Cars cars;

    private RacingGame() {
    }

    public static RacingGame getInstance() {
        return racingGame;
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
