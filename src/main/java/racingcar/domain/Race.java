package racingcar.domain;

import java.util.ArrayList;

public class Race {
    private ArrayList<Car> cars;

    public Race() {
        this.cars = new ArrayList<>();
    }

    public void advanceFullRound(int attempt) {
        for (int round = 0; round < attempt; round++) {
            advanceOneRound();
        }
    }

    public void advanceOneRound() {
        for (Car car : cars) {
            car.moveForward();
            car.print();
        }
    }
}