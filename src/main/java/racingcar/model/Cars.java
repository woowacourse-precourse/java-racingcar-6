package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import racingcar.constant.Error;
import racingcar.util.Utils;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public Cars(String[] carNames) {
        validateCars(carNames);
        carList = generateCarList(carNames);
    }

    public int size() {
        return carList.size();
    }

    public void moveCar(int index) {
        carList.get(index).addPosition();
    }

    public int getMaxPosition() {
        List<Integer> carPositionList = new ArrayList<>();
        for (Car car : carList) {
            carPositionList.add(car.getPosition());
        }
        return Collections.max(carPositionList);
    }

    public List<String> getCarNamesAtPosition(int position) {
        List<String> carNamesAtPosition = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == position) {
                carNamesAtPosition.add(car.getName());
            }
        }
        return carNamesAtPosition;
    }

    public LinkedHashMap<String, Integer> getCarNamePositionMap() {
        LinkedHashMap<String, Integer> carNamePositionMap = new LinkedHashMap<>();
        for (Car car : carList) {
            carNamePositionMap.put(car.getName(), car.getPosition());
        }
        return carNamePositionMap;
    }

    private List<Car> generateCarList(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String car : carNames) {
            carList.add(new Car(car));
        }
        return carList;
    }

    private void validateCars(String[] carNames) {
        if (Utils.hasDuplicateMember(carNames)) {
            throw new IllegalArgumentException(Error.DUPLICATE_CAR_NAME_ERROR.getMessage());
        }
    }
}
