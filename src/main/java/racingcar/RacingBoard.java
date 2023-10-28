package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class RacingBoard {
    private final List<RacingCar> racingBoard = new ArrayList<>();

    public void addRacingCar(final RacingCar racingCar) {
        racingBoard.add(racingCar);
    }

    public void printCarsWithMaxDistance() {
        System.out.println(racingBoard
                .stream()
                .filter(car -> car.getDistance().size() == getMaxDistance())
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "))
        );
    }

    private int getMaxDistance() {
        racingBoard.sort(Comparator.comparingInt(car -> car.getDistance().size()));

        Collections.reverse(racingBoard);

        return racingBoard.get(0).getDistance().size();
    }
}
