package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<Car> cars;
    public RacingCars(List<String> newCars) {
        this.cars = new ArrayList<>();
        setRacingCars(newCars);
    }

    private void setRacingCars(List<String> newCars) {
        for (String carName : newCars) {
            this.cars.add(new Car(carName));
        }
    }

    public void racingStepOne() {
        NumberGenerator ng = new NumberGenerator();
        for (Car thisCar : this.cars) {
            thisCar.move(ng.getRandomNumber());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
