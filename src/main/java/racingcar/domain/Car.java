package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final Integer THRESHOLD = 4;
    private String name;
    private Integer moveNum;


    public Car(String name, Integer moveNum) {
        this.name = name;
        this.moveNum = moveNum;
    }

    public String getName() {
        return name;
    }

    public Integer getMoveNum() {
        return moveNum;
    }

    public void tryMove(int randomNum) {
        if (randomNum >= THRESHOLD) {
            moveOneSpace();
        }
    }

    private void moveOneSpace() {
        moveNum++;
    }


}
