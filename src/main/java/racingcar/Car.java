package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    String carName;
    int movement = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    void move() {
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
        System.out.printf("%s : ", carName);
        for (int move = 0; move < movement; move++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
