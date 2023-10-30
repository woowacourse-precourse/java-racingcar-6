package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    String carName;
    int movement = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    void move(int num) {
        movement += isMovable();
        printCurrentState();
    }

    int isMovable() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            return 1;
        }
        return 0;
    }

    void printCurrentState() {

    }
}
