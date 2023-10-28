package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarRegistry {

    private final List<RacingCar> racingCars = new ArrayList<>();
    private final MoveCount moveCount;

    public RacingCarRegistry(List<String> names, MoveCount moveCount) {
        for (String name : names) {
            racingCars.add(new RacingCar(new Name(name), new Position()));
        }

        this.moveCount = moveCount;
    }
}
