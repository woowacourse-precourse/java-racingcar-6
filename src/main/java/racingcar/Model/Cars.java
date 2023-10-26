package racingcar.Model;

import java.util.ArrayList;
import java.util.List;
import racingcar.Util.RandomGenerator;

public class Cars {

    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<Car>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = RandomGenerator.generateRandomNumber();
            car.move(randomNumber);
        }
    }

}
