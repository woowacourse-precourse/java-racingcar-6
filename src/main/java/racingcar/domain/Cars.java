package racingcar.domain;

import racingcar.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String DELIMITER = ",";

    private final String names;
    private final List<Car> cars = new ArrayList<>();
    private final RandomNumber randomNumber = new RandomNumber();

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
        return names.split(DELIMITER);
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public List<String> findLongDistanceCarsName() {
        int max = -1;
        List<String> longDistanceCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() >= max) {
                longDistanceCars.add(car.getName());
            }
        }
        return longDistanceCars;
    }

    public void moveCars() {
        for (Car car : cars) {
            if (car.isMoreThanCondition(generateNumber())) {
                car.move();
            }
        }
    }

    public int size() {
        return cars.size();
    }

    private int generateNumber() {
        return randomNumber.create();
    }
}
