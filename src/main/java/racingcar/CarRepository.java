package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        this.cars.add(car);
    }

    public void setCarForward() {
        for (Car car : this.cars) {
            if (car.setRandomNumber() >= 4) {
                car.setForward();
            }
        }
    }

    public void getCarStatus() {
        for (Car car : this.cars) {
            System.out.println(car.getName() + " : " + car.getForward());
        }
    }


}
