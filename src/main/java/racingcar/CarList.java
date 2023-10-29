package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.Model.Car;

public class CarList {
    private List<Car> carList = new ArrayList<Car>();

    public CarList(String[] names) {
        validateSameName(names);
    }

    void validateSameName(String[] names) {
        for (String name : names) {
            Car car = new Car(name);

            if (carList.contains(car)) {
                throw new IllegalArgumentException("자동차 이름을 모두 다르게 입력해주세요.");
            }

            carList.add(car);
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

}
