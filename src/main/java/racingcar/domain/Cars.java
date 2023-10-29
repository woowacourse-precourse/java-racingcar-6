package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final String names;
    private final List<Car> cars = new ArrayList<>();

    public Cars(String names) {
        this.names = names;
        String[] separateName = separateName();
        createCars(separateName);
    }

    private void createCars(String[] separateName) {
        for (String name : separateName) {
            cars.add(new Car(name));
        }
    }

    private String[] separateName() {
        return names.split(",");
    }

    public Car getCar(int index) {
        return cars.get(index);
    }
}
