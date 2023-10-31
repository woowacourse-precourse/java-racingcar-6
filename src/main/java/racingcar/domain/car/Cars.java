package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(String carName) {
        cars.add(new Car(carName));
    }

    public Car getCar(int index){
        return cars.get(index);
    }

    public List<Car> getAllCars() {
        return cars;
    }

}
