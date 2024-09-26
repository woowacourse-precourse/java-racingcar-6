package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void registerCars(String carNames) {
        String[] names = checkValid(carNames);
        for (String name : names) {
            addCar(name);
        }
    }

    private String[] checkValid(String carNames) {
        String[] names = carNames.split(",");
        Validator.checkMinimumParticipants(names);
        trimSpaces(names);
        Validator.isNameDuplicate(names);

        for (String name : names) {
            Validator.isSpace(name);
            Validator.checkNameLength(name);
        }

        return names;
    }

    public void trimSpaces(String[] names) {
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
    }

    private void addCar(String name) {
        Car car = new Car(name);
        cars.add(car);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
