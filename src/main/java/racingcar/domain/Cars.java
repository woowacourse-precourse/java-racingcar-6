package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public Cars(String[] cars) {
        validateCars(cars);
        carList = generateCarList(cars);
    }


    public List<String> getVictoryCarsName() {
        List<String> victoryCarsName = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : carList) {
            if (maxPosition == car.getPosition()) {
                victoryCarsName.add(car.getName());
            }
        }
        return victoryCarsName;
    }

    private int getMaxPosition() {
        List<Integer> carPositionList = new ArrayList<>();
        for (Car car : carList) {
            carPositionList.add(car.getPosition());
        }
        return Collections.max(carPositionList);
    }

    public int size() {
        return carList.size();
    }

    public void moveCarPosition(int index) {
        carList.get(index).addPosition();
    }

    private List<Car> generateCarList(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            carList.add(new Car(car));
        }
        return carList;
    }

    private void validateCars(String[] cars) {
        if (hasDuplicatedCarName(cars)) {
            throw new IllegalArgumentException("중복된 자동차 이름을 입력하였습니다.");
        }
    }

    private boolean hasDuplicatedCarName(String[] cars) {
        HashSet<String> carSet = new HashSet<String>();
        Collections.addAll(carSet, cars);
        return cars.length > carSet.size();
    }
}
