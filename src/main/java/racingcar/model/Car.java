package racingcar.model;

import racingcar.util.Utils;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 1;
    }

    public void printRoundResult() {
        String totalDistance = Utils.convertDistanceToSymbol(distance);
        System.out.println(name + " : " + totalDistance);
    }
}
