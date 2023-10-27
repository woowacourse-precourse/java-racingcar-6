package racingcar.model;

import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(RacingCarsListMaker racingCarsListMaker) {
        this.racingCars = racingCarsListMaker.getRacingCarsList();
    }

    public List<String> getWinners() {
        int maxMoveDistance = getMaxMoveDistance();
        List<String> winners = findWinners(maxMoveDistance);
        return winners;
    }

    private int getMaxMoveDistance() {
        return racingCars.stream()
                .mapToInt(RacingCar::getMoveDistance)
                .max()
                .getAsInt();
    }

    private List<String> findWinners(int maxMoveDistance) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getMoveDistance() == maxMoveDistance)
                .map(RacingCar::getName)
                .toList();
    }
}
