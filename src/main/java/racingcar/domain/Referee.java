package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Referee {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int THRESHOLD = 4;

    private static void moveRacingCarByThreshold(RacingCar racingCar, int randomNumber) {
        if (randomNumber >= THRESHOLD) {
            racingCar.move();
        }
    }

    private static void addWinnerByFarthestDistance(RacingCars winners, RacingCar racingCar, int farthest) {
        if (racingCar.getDistance() == farthest) {
            winners.add(racingCar);
        }
    }

    public static void simulate(RacingCars racingCars) {
        for (int i = 0; i < racingCars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            moveRacingCarByThreshold(racingCars.get(i), randomNumber);
        }
    }

    public static RacingCars calculateWinners(RacingCars racingcars) {
        int farthest = racingcars.farthestDistance();
        RacingCars winners = new RacingCars();
        for (int i = 0; i < racingcars.size(); i++) {
            addWinnerByFarthestDistance(winners, racingcars.get(i), farthest);
        }
        return winners;
    }
}