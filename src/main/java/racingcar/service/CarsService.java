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
        for (int index = 0; index < cars.size(); index++) {
            moveCarOrNot(index, Utils.getRandomNumber());
        }
    }

    // 테스트를 위해 public 접근 제한자 설정
    public void moveCarOrNot(int index, int randomNumber) {
        if (randomNumber >= NumberConstant.TARGET_NUMBER) {
            Car car = cars.getCar(index);
            car.addPosition();
        }
    }
}
