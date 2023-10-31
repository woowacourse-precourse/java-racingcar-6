package racingcar.domain;

import racingcar.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String DELIMITER = ",";

    private final String names;
    private final List<Car> cars = new ArrayList<>();
    private final List<String> longDistanceCars = new ArrayList<>();
    private final RandomNumber randomNumber = new RandomNumber();

    public Cars(String names) {
        this.names = names;
        List<String> separateName = separateName();
        createCars(separateName);
    }

    private void createCars(List<String> separateName) {
        for (String name : separateName) {
            cars.add(new Car(name));
        }
    }

    private List<String> separateName() {
        return List.of(names.split(DELIMITER));
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public List<String> findLongDistanceCarsName() {
        int max = -1;

        for (Car car : cars) {
            max = compare(car, max);
        }
        return longDistanceCars;
    }

    private int compare(Car car, int max) {
        int distance = car.getDistance();
        if (distance > max) {
            longDistanceCars.clear();
            longDistanceCars.add(car.getName());
            return distance;
        }
        if (distance == max){
            longDistanceCars.add(car.getName());
        }
        return max;
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
