package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int moveCount;
    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }
    public void randomMove(){
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if (randomNumber >= 4) moveCount++;
    }
    public String gameResultString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
