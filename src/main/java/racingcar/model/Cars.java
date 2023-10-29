package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.NullException;
import racingcar.exception.cars.DuplicateException;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        validateCarList(carList);
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Integer> getPositionList() {
        List<Integer> positions = new ArrayList<>();
        carList.forEach(car -> positions.add(car.getPosition()));
        return positions;
    }

    public Car get(int index) {
        return carList.get(index);
    }

    public int size() {
        return carList.size();
    }

    private void validateCarList(List<Car> carList) {
        validateNull(carList);
        validateDuplicateName(carList);
    }

    private void validateNull(List<Car> carList) {
        if (carList == null) {
            throw new NullException();
        }
    }

    private void validateDuplicateName(List<Car> carList) {
        List<String> carNameList = new ArrayList<>();
        for (Car car : carList) {
            carNameList.add(car.getName());
        }
        if (carNameList.stream()
                .distinct()
                .count() != carNameList.size()) {
            throw new DuplicateException();
        }
    }
}
