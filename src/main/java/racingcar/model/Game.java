package racingcar.model;

import java.util.List;

public class Game {

    private Car[] cars;
    private int tryCnt;

    public Game(List<String> carNames, int tryCnt) {
        int numOfCar = carNames.size();
        this.cars = new Car[numOfCar];

        for (int i = 0; i < numOfCar; i++) {
            cars[i] = new Car(carNames.get(i));
        }

        this.tryCnt = tryCnt;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getTryCnt() {
        return tryCnt;
    }
}
