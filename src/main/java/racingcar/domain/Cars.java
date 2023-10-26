package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.StringParser;

public class Cars {

    private List<Car> cars;

    public Cars(String carName) {
        this.cars = toCarList(carName);
    }

    private List<Car> toCarList(String carName) {
        List<String> carNameList = StringParser.toCarNameList(carName);
        List<Car> cars = new ArrayList<>();
        for (String name : carNameList) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }
}
