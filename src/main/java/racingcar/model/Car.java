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
        pickRandomNumber();
        if(checkRandomNumber()) {
            forward();
        }
    }

    public void pickRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
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
}
