package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class RacingBoard {
    private final List<RacingCar> racingBoard = new ArrayList<>();

    public void addRacingCar(final RacingCar racingCar) {
        racingBoard.add(racingCar);
    }

    public void racingCarsMove() {
        for (RacingCar racingCar : racingBoard) {
            racingCar.move();
        }
        System.out.println();
    }

    public String carsWithMaxDistance() {

        final int maxDistance = getMaxDistance();

        return racingBoard
                .stream()
                .filter(car -> car.getDistance().size() == maxDistance)
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "));
    }

    private int getMaxDistance() {
        return racingBoard.stream()
                .mapToInt(car -> car.getDistance().size())
                .max()
                .orElse(0);
    }
}
