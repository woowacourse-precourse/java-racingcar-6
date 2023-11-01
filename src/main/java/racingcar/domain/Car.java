package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final static int FIRST_FORWARD_NUM = 0;
    private final static int RANDOM_MIN_VALUE = 0;
    private final static int RANDOM_MAX_VALUE = 9;

    private String name;
    private int forwardNum;
    private int randomNum;

    public Car(String name) {
        this.name = name;
        this.forwardNum = FIRST_FORWARD_NUM;
    }

    public String getName() {
        return this.name;
    }

    public int getForwardNum() {
        return this.forwardNum;
    }

    public int getRandomNum() {
        return this.randomNum;
    }

    public void increaseForwardNum() {
        this.forwardNum++;
    }

    public void initRandomNum() {
        this.randomNum = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
    }
}
