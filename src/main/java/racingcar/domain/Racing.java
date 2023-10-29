package racingcar.domain;

import java.util.List;

public class Racing {
    private List<Car> racingCars;

    public Racing(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public List<Car> getRacingCars(){
        return racingCars;
    }

    public List<Car> race(){
        for(Car car: racingCars){
            car.drive();
        }
        return racingCars;
    }
}
