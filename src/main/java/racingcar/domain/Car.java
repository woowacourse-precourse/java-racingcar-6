package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moveCount = 0;
    public int randomNum = Randoms.pickNumberInRange(0,9);

    public Car(String name) {
        this.name = name;
    }

    public int getForwardCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    public void modifyRandomNum() {
        randomNum = Randoms.pickNumberInRange(0,9);
    }
    public int moveForward() {
        if(randomNum > 3) {
            moveCount++;
        }
        return moveCount;
    }

    public void displayMoveCount() {
        System.out.print(name + " : ");
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }
}
