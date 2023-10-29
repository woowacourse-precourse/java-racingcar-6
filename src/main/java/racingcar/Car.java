package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    Information information;
    Car (String name) {
        information = new Information(name);
    }

    void move() {
        if (moveSuccessfully()) {
            information.update();
        }
    }

    boolean moveSuccessfully() {
        int speed;

        speed = Randoms.pickNumberInRange(0,9);
        if (speed >= 4) {
            return (true);
        }
        return (false);
    }

    void printInformation() {
        information.print();
    }

    String getName() {
        return (information.getName());
    }

    int getDestination() {
        return (information.getDestination());
    }
}
