package racingcar;

import java.util.List;
import java.util.stream.Collectors;

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
        racingCars.stream()
            .map(racingCar -> racingCar.getName() + " : " + getPositionBar(racingCar))
            .forEach(System.out::println);
    }

    private String getPositionBar(RacingCar racingCar) {
        int positionBarLength = racingCar.getPosition();
        return POSITION_BLOCK.repeat(positionBarLength);
    }

    public void printWinnersName() {
        System.out.println(getWinnersName());
    }

    private String getWinnersName() {
        final int winnerPosition = getWinnerPosition();

        return racingCars.stream()
            .filter(racingCar -> racingCar.getPosition() == winnerPosition)
            .map(RacingCar::getName)
            .collect(Collectors.joining(", "));
    }

    private int getWinnerPosition() {
        return racingCars.stream()
            .mapToInt(RacingCar::getPosition)
            .max()
            .orElse(0);
    }
}
