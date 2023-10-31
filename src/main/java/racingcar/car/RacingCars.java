package racingcar.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {

    private List<Car> racingCars;

    public RacingCars(String[] cars){
        racingCars = new ArrayList<>();

        for(String name : cars){
            racingCars.add(new RacingCar(name));
        }
    }
}
