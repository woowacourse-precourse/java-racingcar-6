package racingcar.model;

import java.util.List;

public class RacingReferee {

    private RacingReferee() {
    }

    public static Winners getWinners(List<RacingCar> racingCars) {
        final int winnerPosition = getWinnerPosition(racingCars);
        return new Winners(getWinners(racingCars, winnerPosition));
    }

    private static int getWinnerPosition(List<RacingCar> racingCars) {
        return racingCars.stream()
            .mapToInt(RacingCar::getPosition)
            .max()
            .orElse(0);
    }

    private static List<String> getWinners(List<RacingCar> racingCars, int winnerPosition) {
        return racingCars.stream()
            .filter(racingCar -> racingCar.getPosition() == winnerPosition)
            .map(RacingCar::getName)
            .toList();
    }
}
