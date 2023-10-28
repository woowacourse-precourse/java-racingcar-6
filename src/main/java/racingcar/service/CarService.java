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
            car.modifyRandomNum();
            car.moveForward();
        }
    }

    public void displayForwardCounts(List<Car> carList) {
        for (Car car : carList) {
            car.displayMoveCount();
        }
    }
}
