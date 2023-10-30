package racingcar.service;

import java.util.List;
import racingcar.domain.RacingCar;

public class Referee {

    private static final String WINNER_SEPARATOR = ", ";

    public static String generateRaceWinnersList(List<RacingCar> racingCars) {
        int max = getMaxDistance(racingCars);
        StringBuilder tmp = new StringBuilder();

        for (RacingCar racingCar : racingCars) {
            addRacingCarNameIfWinner(racingCar, max, tmp);
        }
        return tmp.substring(0, tmp.length() - 2);
    }

    private static void addRacingCarNameIfWinner(RacingCar racingCar, int max, StringBuilder tmp) {
        if (racingCar.getDistance() == max) {
            tmp.append(racingCar.getCarName()).append(WINNER_SEPARATOR);
        }
    }

    public static int getMaxDistance(List<RacingCar> racingCars) {
        int maxDistance = 0;
        for (RacingCar racingCar : racingCars) {
            maxDistance = Math.max(maxDistance, racingCar.getDistance());
        }
        return maxDistance;
    }

}