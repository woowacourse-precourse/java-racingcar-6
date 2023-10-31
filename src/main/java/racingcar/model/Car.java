package racingcar.model;

import racingcar.util.Utils;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void getResult() {
        if (Utils.getRandomNumber() > 3) {
            this.distance += 1;
        }
    }

    public void printRoundResult() {
        String totalDistance = Utils.convertDistanceToSymbol(distance);
        System.out.println(name + " : " + totalDistance);
    }

    public int getDistance() {
        return distance;
    }

    public boolean isWinner(int winningDistance) {
        return this.distance == winningDistance;
    }

    public String getName() {
        return name;
    }
}
