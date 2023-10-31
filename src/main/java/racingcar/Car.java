package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    final private String name;
    private int forward = 0;
    private String carState;

    Car(String name) {
        this.name = name;
        this.carState = name + " : ";
    }

    public void goForward() {
        int randomNumber;
        randomNumber = Randoms.pickNumberInRange(0, 9);
        isGreaterThan4(randomNumber);
        Message.makeResultMessage(this.carState);
    }

    private void isGreaterThan4(int randomNumber) {
        if (randomNumber >= 4) {
            this.forward++;
            this.carState = this.carState.concat("-");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getForward() {
        return this.forward;
    }
}
