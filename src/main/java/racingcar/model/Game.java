package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int numberOfAttempts;
    private List<Car> cars;
    private List<String> winners;

    public Game(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public void addCar(String nameOfCar) {
        cars.add(new Car(nameOfCar));
    }
}
