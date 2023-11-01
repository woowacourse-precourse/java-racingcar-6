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
            for (RacingCar racingCar: racingCars) {
                racingCar.move();
            }
        }
    }

    private void printRaceStatus() {
        for (RacingCar racingCar : racingCars) {
            System.out.print(racingCar.getName() + " : ");
            for (int j = 0; j < racingCar.getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}