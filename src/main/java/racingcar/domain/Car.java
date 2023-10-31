package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private final Round round;

    public Car(String name) {
        this.name = name;
        this.round = new Round();
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void move() {
        int randomNumber = getRandomNumber();
        this.round.move(randomNumber);
    }

    public String getRecord() {
        return this.round.getRecord(this.name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.round.getPosition();
    }
}
