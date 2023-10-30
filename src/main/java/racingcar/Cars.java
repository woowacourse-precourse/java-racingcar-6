package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCar(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            if (!validateName(name)) {
                throw new IllegalArgumentException(Constant.NAME_ERROR_MESSAGE);
            }
            cars.add(new Car(name));
        }
    }

    public void printCars() {
        for (Car car : cars) {
            System.out.println(car.getName());
        }
    }

    public boolean validateName(String carName) {
        if (carName.length() > Constant.MAXIMUM_NAME_NUMBER) {
            return false;
        }
        return carName.length() != Constant.INVALID_NAME_LENGTH;
    }
}
