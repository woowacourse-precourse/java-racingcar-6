package racingcar.game;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.util.RandomNumberGenerator;

public final class RacingGame {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private final InputProvider inputProvider;
    private final RandomNumberGenerator randomNumberGenerator;
    private Cars cars;

    public RacingGame() {
        this(InputProvider.getInstance(), new RandomNumberGenerator());
    }

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this(InputProvider.getInstance(), randomNumberGenerator);
    }

    public RacingGame(InputProvider inputProvider, RandomNumberGenerator randomNumberGenerator) {
        this.inputProvider = inputProvider;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void startGame() {
        String names = inputProvider.receiveCarNames();
        int raceCount = inputProvider.receiveRaceCount();

        cars = Cars.fromNames(names);

        playGame(raceCount);
    }

    private void playGame(int raceCount) {
        RacingStatus racingStatus = new RacingStatus();
        for (int round = 1; round <= raceCount; round++) {
            cars.race(getRandomNumbers());
            System.out.println(racingStatus.getRaceProgress(cars.carList()));
        }

        List<Car> winnerList = cars.findWinners();
        System.out.println(racingStatus.getWinners(winnerList));
    }

    private List<Integer> getRandomNumbers() {
        return randomNumberGenerator.createRandomNumberListInRange(MIN_RANGE, MAX_RANGE, cars.totalCars());
    }
}
