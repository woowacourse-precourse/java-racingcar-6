package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private String forwardMovementState;
    private int randomNumber;

    public Car(String name) {
        this.name = name;
        this.forwardMovementState = "";
    }

    /**
     * 랜덤 숫자를 뽑고 랜덤 숫자가 4 이상이라면 전진
     */
    public void playRound() {
        pickRandomNumber(0,9);
        if (checkRandomNumber()) {
            forward();
        }
    }

    public void pickRandomNumber(int startRange, int endRange) {
        this.randomNumber = Randoms.pickNumberInRange(startRange, endRange);
    }

    public boolean checkRandomNumber() {
        return this.randomNumber >= 4;
    }

    public void forward() {
        this.forwardMovementState += "-";
    }

    public String getNameAndStateOfCar() {
        return this.name + " : " + this.forwardMovementState;
    }

    public int getForwardMovementStateOfLength() {
        return this.forwardMovementState.length();
    }

    public String getName() {
        return this.name;
    }
}
