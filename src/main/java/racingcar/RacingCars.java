package racingcar;

import java.util.List;

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
}
