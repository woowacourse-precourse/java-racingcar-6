package racingcar.model;

import java.util.List;

public class Game {

    private Car[] cars;
    private int round;

    public Game(List<String> carNames, int round) {
        int numOfCar = carNames.size();
        this.cars = new Car[numOfCar];

        for (int i = 0; i < numOfCar; i++) {
            cars[i] = new Car(carNames.get(i));
        }

        this.round = round;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }
}
