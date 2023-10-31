package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private String name;
    private int place;

    public RacingCar(String name) {
        this.name = name;
        this.place = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            place += 1;
    }

    public void display() {
        System.out.print(name + " : ");

        for(int i = 0; i < place; i++) {
            System.out.print("-");
        }
    }
}
