package racingcar.model;

import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void race() {
        racingCars.forEach(RacingCar::race);
    }

    public List<CarPosition> getCarCurrentPositions() {
        return racingCars.stream()
            .map(this::getCarPosition)
            .toList();
    }

    public Winners getWinners() {
        return RacingReferee.getWinners(List.copyOf(racingCars));
    }

    private CarPosition getCarPosition(RacingCar racingCar) {
        return new CarPosition(racingCar.getName(), racingCar.getPosition());
    }
}
