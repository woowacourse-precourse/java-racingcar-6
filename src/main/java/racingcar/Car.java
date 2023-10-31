package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    Car(String name){
        this.name = name;
        this.distance = 0;
    }

    void move_forward(Car car){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.distance++;
        }
    }
}
