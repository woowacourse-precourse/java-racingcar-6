package racingcar.domain;

import racingcar.view.Output;
import camp.nextstep.edu.missionutils.Randoms;

class Car {
    private String name;
    private int forwardCount;

    Car(String name) {
        Validator.checkNameRestriction(name);
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    int getForwardCount() {
        return this.forwardCount;
    }

    void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            forwardCount++;
        }
    }

    void currentLocation() {
        System.out.print(name + " : ");
        for (int i = 0; i < forwardCount; i++) {
            System.out.print("-");
        }
        Output.newLine();
    }
}
