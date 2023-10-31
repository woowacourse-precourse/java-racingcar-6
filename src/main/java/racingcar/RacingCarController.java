package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    private static List<RacingCar> racingCarList = new ArrayList<>();

    public static RacingCar registerRacingCar(String name) {
        RacingCar newRacingCar = new RacingCar(name, 0);
        racingCarList.add(newRacingCar);
        return newRacingCar;
    }
}
