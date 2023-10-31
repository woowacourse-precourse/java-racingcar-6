package racingcar.domain;

import java.util.List;

public class RacingCars {

    private List<Car> racingCars;

    public RacingCars(List<String> carNames){
        for(String carName : carNames){
            racingCars.add(new Car(carName));
        }
    }
}
