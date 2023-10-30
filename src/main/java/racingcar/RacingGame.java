package racingcar;

public class RacingGame {
    private final Cars cars;
    private final Lap lap;

    RacingGame(Cars cars, Lap lap) {
        this.cars = cars;
        this.lap = lap;
    }

    public void play() {
        GameIO.printResultMessage();

        int currentLapSize = 1;
        Lap currentLap = new Lap(currentLapSize);
        while (!lap.isFinish(currentLap)) {
            cars.race();
            cars.printRaceStatus();
            currentLap = new Lap(++currentLapSize);
        }

        GameIO.printWinners(cars.getWinner());
    }

}

