package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import racingcar.constant.NumberConstant;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.Utils;

public class CarsService {
    private final Cars cars;

    public CarsService(Cars cars) {
        this.cars = cars;
    }

    public LinkedHashMap<String, Integer> getCarNamePositionMap() {
        LinkedHashMap<String, Integer> carNamePositionMap = new LinkedHashMap<>();
        for (int index = 0; index < cars.size(); index++) {
            Car car = cars.getCar(index);
            carNamePositionMap.put(car.getName(), car.getPosition());
        }
        return carNamePositionMap;
    }

    public List<String> getCarNamesAtPosition(int position) {
        List<String> maxPositionCarNames = new ArrayList<>();
        for (int index = 0; index < cars.size(); index++) {
            Car car = cars.getCar(index);
            if (car.getPosition() == position) {
                maxPositionCarNames.add(car.getName());
            }
        }
        return maxPositionCarNames;
    }

    public int getMaxPosition() {
        List<Integer> carPositionList = new ArrayList<>();
        for (int index = 0; index < cars.size(); index++) {
            Car car = cars.getCar(index);
            carPositionList.add(car.getPosition());
        }
        return Collections.max(carPositionList);
    }

    public void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            if (Utils.getRandomNumber() >= NumberConstant.TARGET_NUMBER) {
                moveCar(i);
            }
        }
    }

    private void moveCar(int index) {
        Car car = cars.getCar(index);
        car.addPosition();
    }
}
