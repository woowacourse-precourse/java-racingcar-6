package racingcar.model;

import java.util.List;

public class RacingCars {

    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public void generateRacingCars(String inputCarName) {
        for (String carName : inputCarName.split(",")) {
            Car generatedCar = new Car(carName);
            racingCars.add(generatedCar);
        }
    }
}
