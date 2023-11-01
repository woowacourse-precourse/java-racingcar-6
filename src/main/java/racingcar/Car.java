package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }
    public int getPosition() {
        return this.position;
    }

    public void move() {
        if(isCarMoving()) {
            this.position++;
        }
    }
    private boolean isCarMoving() {
        int carPos = Randoms.pickNumberInRange(0, 9);
        return carPos >= 4;
    }
    public void printCarMoving() {
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
