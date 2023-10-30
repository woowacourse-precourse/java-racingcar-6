package racingcar.domain;

import java.util.ArrayList;

public class Race {
    private ArrayList<Car> cars;
    private int attempt;

    public Race(int attempt) {
        this.cars = new ArrayList<>();
    }

    public void advanceFullRound() {
        for (int round = 0; round < attempt; round++) {
            advanceOneRound();
            System.out.println();
        }
    }

    public void advanceOneRound() {
        for (Car car : cars) {
            car.moveForward();
            car.print();
        }
    }
}