package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingReferee {

    private RacingReferee() {
    }

    public static void printWinnersName(List<RacingCar> racingCars) {
        final int winnerPosition = getWinnerPosition(racingCars);
        System.out.println(getWinnersName(racingCars, winnerPosition));
    }

    private static String getWinnersName(List<RacingCar> racingCars, int winnerPosition) {
        return racingCars.stream()
            .filter(racingCar -> racingCar.getPosition() == winnerPosition)
            .map(RacingCar::getName)
            .collect(Collectors.joining(", "));
    }

    private static int getWinnerPosition(List<RacingCar> racingCars) {
        return racingCars.stream()
            .mapToInt(RacingCar::getPosition)
            .max()
            .orElse(0);
    }
}
