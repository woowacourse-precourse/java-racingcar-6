package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int MIN_POWER = 0;
    private final int MAX_POWER = 9;

    private final String name;
    private int Position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return Position;
    }

    public String getName() {
        return name;
    }

    public int moveForward() {
        return moveForward(Randoms.pickNumberInRange(MIN_POWER, MAX_POWER));
    }

    public int moveForward(int power) {
        if(power > 3) {
            Position++;
        }
        return Position;
    }

    public void displayPosition() {
        String positionStr = "";
        for (int i = 0; i < Position; i++) {
            positionStr += "-";
        }
        System.out.println(name + " : " + positionStr);
    }
}
