package racingcar.Model;

import racingcar.View.TextInterface;

public class Car {
    private String name;
    private int distance;
    TextInterface textInterface = new TextInterface();

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void go(int num) {
        if (num >= 4) {
            distance++;
        }
        textInterface.printDistance(name, distance);
    }

    public int getDistance() {
        return distance;
    }

    public void win() {
        textInterface.printWinner(name);
    }

    public void jointWin() {
        textInterface.printJointWinner(name);
    }
}
