package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList(List<Car> carList) {
        validateNull(carList);
        validateDuplicateName(carList);
        this.carList = carList;
    }

    private void validateNull(List<Car> carList) {
        if (carList == null) {
            throw new IllegalArgumentException("null이 입력되었습니다.");
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
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car get(int index) {
        return carList.get(index);
    }

    public int size() {
        return carList.size();
    }
}
