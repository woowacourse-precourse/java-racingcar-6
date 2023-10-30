package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarService {

    public List<Car> createCar(String carName) {
        List<Car> carList = new ArrayList<>();
        String[] carNameArray = carName.split(",");
        for(String name : carNameArray) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void moveForwards(List<Car> carList) {
        for(int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.moveForward();
        }
    }
    public void moveForwards(List<Car> carList, int power) {
        for(int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.moveForward(power);
        }
    }

    public void displayPositions(List<Car> carList) {
        for (Car car : carList) {
            car.displayPosition();
        }
    }
}
