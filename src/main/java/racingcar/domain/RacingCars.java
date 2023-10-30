package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<Car> racingCars;

    public RacingCars(String carNames) {
       initRacingCars(carNames);
    }

    public void initRacingCars(String carNames){
        String[] carNameIndex = carNames.split(",");
        this.racingCars = new ArrayList<>();

        for(String car : carNameIndex){
            this.racingCars.add(new Car(car));
        }
    }

}
