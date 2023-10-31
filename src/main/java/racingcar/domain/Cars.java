package racingcar.domain;

import static racingcar.InputValidator.validateCarName;
import java.util.ArrayList;

public class Cars {
    private ArrayList<Car> cars;
    public Cars(ArrayList<String> carNames) {
        this.cars = createCarListFromNames(carNames);
    }

    private ArrayList<Car> createCarListFromNames(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateCarName(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    public Car getIndex(int i) {
        if (i < 0 || i >= cars.size()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + cars.size());
        }
        return cars.get(i);
    }
    public ArrayList<Car> getCars() {
        return cars;
    }
    public int size() {
        return cars.size();
    }
}

