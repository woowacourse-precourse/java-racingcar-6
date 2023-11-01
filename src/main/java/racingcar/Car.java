package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public String name;
    public int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void takeTurn() {
        int randomNumber = getRandomNumber();
        if (canMoveForward(randomNumber)) {
            this.distance += 1;
        }
    }

    public boolean canMoveForward(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
