package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.ScoreBoard;

public class RacingCars {

    private static final String POSITION_BLOCK = "-";
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void race() {
        racingCars.forEach(RacingCar::race);
    }

    public void printCarsPosition() {
        String carsPosition = getCarsPosition();
        ScoreBoard.displayRacingProgress(carsPosition);
    }

    public void printWinnersName() {
        RacingReferee.printWinnersName(List.copyOf(racingCars));
    }

    private String getCarsPosition() {
        return racingCars.stream()
            .map(racingCar -> racingCar.getName() + " : " + getPositionBar(racingCar))
            .collect(Collectors.joining("\n"));
    }

    private String getPositionBar(RacingCar racingCar) {
        int positionBarLength = racingCar.getPosition();
        return POSITION_BLOCK.repeat(positionBarLength);
    }
}
