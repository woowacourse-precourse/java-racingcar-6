package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarRegistry {

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCarRegistry(List<String> names) {
        for (String name : names) {
            racingCars.add(new RacingCar(new Name(name), new Position()));
        }
    }
}
