package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    final private String name;
    private String go = "";

    Car(String name) {
        this.name = name;
    }

    public void goForward(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            checkValue(randomNumber);
        }
    }

    private void checkValue(int randomNumber) {
        if (randomNumber >= 4)
            this.go += "-";
    }
}
