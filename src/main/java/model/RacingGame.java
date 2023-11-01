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
            printRaceStatus();
        }
        announceWinners();
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

    private void announceWinners() {
        int maxPosition = getMaxPosition();
        StringBuilder winners = new StringBuilder();
        for (RacingCar car : racingCars) {
            if (car.getPosition() == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(car.getName());
            }
        }
        System.out.println("최종 우승자: " + winners);
    }

    private int getMaxPosition() {
        int maxPosition = -1;
        for (RacingCar car : racingCars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}