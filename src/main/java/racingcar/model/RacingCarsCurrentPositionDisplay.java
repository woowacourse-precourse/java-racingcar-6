package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.ScoreBoard;

public class RacingCarsCurrentPositionDisplay {

    private static final String POSITION_BLOCK = "-";

    public static void displayCurrentRacingCarsPosition(List<RacingCar> racingCars) {
        String carsPosition = getCarsPosition(racingCars);
        ScoreBoard.displayCurrentRacingCarsPosition(carsPosition);
    }

    private static String getCarsPosition(List<RacingCar> racingCars) {
        return racingCars.stream()
            .map(racingCar -> racingCar.getName() + " : " + getPositionBar(racingCar))
            .collect(Collectors.joining("\n"));
    }

    private static String getPositionBar(RacingCar racingCar) {
        int positionBarLength = racingCar.getPosition();
        return POSITION_BLOCK.repeat(positionBarLength);
    }
}
