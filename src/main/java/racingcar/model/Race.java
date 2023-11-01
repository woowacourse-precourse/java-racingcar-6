package racingcar.model;

import java.util.ArrayList;

public class Race {
    private ArrayList<Car> cars;

    public Race(ArrayList<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
