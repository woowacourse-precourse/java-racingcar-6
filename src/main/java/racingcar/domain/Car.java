package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String car_name;
    private int move_count;

    public Car(String car_name) {
        this.car_name = car_name;
        this.move_count = 0;
    }

    public int getMove_count() {
        return move_count;
    }

    public String getCar_name() {
        return car_name;
    }

    public void determine_Move() {
        if (Randoms.pickNumberInRange(0, 9) > 4) {
            this.move_count++;
        }
    }

}
