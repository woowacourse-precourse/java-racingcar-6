package racingcar.Model;

import static racingcar.Constants.ErrorMessage.SAME_NAME;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarList {
    private List<Car> carList = new ArrayList<Car>();

    public CarList(String[] names) {
        validateSameName(names);
    }

    void validateSameName(String[] names) {
        for (String name : names) {
            Car car = new Car(name);

            if (carList.contains(car)) {
                throw new IllegalArgumentException(SAME_NAME.getMessage());
            }

            carList.add(car);
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

}
