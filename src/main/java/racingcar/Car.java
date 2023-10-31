package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    final private String name;
    private int forward = 0;
    private String carState;

    Car(String name) {
        this.name = name;
    }

    public void goForward(int numberOfTimes) {
        int randomNumber;
        for (int i = 0; i < numberOfTimes; i++) {
            randomNumber = Randoms.pickNumberInRange(0, 9);
            checkValue(randomNumber);
        }
        Message.makeResultMessage(this.name, this.forward);
    }

    private void checkValue(int randomNumber) {
        if (randomNumber >= 4)
            this.forward++;
    }

    public String getName() {
        return this.name;
    }

    public int getForward() {
        return this.forward;
    }
}
