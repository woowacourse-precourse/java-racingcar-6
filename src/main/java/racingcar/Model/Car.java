package racingcar.Model;

import static racingcar.Util.Constants.GO_OR_NOT;

import racingcar.View.TextInterface;

public class Car {
    private final String name;
    private int distance;
    TextInterface textInterface = new TextInterface();

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void go(int num) {
        if (num >= GO_OR_NOT) {
            distance++;
        }
        textInterface.printDistance(name, distance);
    }

    public void printWinner() {
        textInterface.printWinner(name);
    }

    public void printJointWinner() {
        textInterface.printJointWinner(name);
    }
}
