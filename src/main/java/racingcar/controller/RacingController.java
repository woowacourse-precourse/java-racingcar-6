package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    public RacingCars init(List<String> names) {

        List<RacingCar> racingCars = new ArrayList<>();
        for(String name : names){
            racingCars.add(RacingCar.from(name));
        }
        return RacingCars.from(racingCars);
    }
}
