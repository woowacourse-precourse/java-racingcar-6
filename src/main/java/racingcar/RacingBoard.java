package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class RacingBoard {
    private final List<RacingCar> racingBoard = new ArrayList<>();

    public void addRacingCar(final RacingCar racingCar) {
        this.racingBoard.add(racingCar);
    }

    public void racingCarsMove() {
        for (RacingCar racingCar : this.racingBoard) {
            racingCar.move();
        }
        System.out.println();
    }

    public String carsWithMaxDistance() {

        final int maxDistance = getMaxDistance();

        return this.racingBoard
                .stream()
                .filter(car -> car.getDistance().size() == maxDistance)
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "));
    }

    public int getMaxDistance() {
        return this.racingBoard.stream()
                .mapToInt(car -> car.getDistance().size())
                .max()
                .orElse(0);
    }
}
