package model;

public class RacingGame {
    private RacingCar[] racingCars;
    private int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.tryCount = tryCount;
        racingCars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            racingCars[i] = new RacingCar(carNames[i]);
        }
    }

    public void play() {
        for (int i = 0; i < tryCount; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.move();
            }
        }
    }
}
