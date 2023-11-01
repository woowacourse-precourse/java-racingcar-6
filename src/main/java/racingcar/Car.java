package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int forwardDistanceBetweenStartLine = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int forwardDistanceBetweenStartLine) {
        this(name);
        this.forwardDistanceBetweenStartLine = forwardDistanceBetweenStartLine;
    }

    public String getName() {
        return name;
    }

    public int getForwardDistanceBetweenStartLine() {
        return forwardDistanceBetweenStartLine;
    }

    public void tryForwardByCondition(int randomNumber) {
        if (randomNumber >= 4) {
            forwardDistanceBetweenStartLine += 1;
        }
    }

    public void locationInfoVisualizing() {
        StringBuilder info = new StringBuilder(name + " : ");

        for (int i = 0; i < forwardDistanceBetweenStartLine; i++) {
            info.append("-");
        }
        System.out.println(info);
    }

}
