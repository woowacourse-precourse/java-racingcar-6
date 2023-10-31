package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int number_go;

    public Car(String name) {
        this.name = name;
        this.number_go = 0;
    }

    public void go() {
        int random_number = Randoms.pickNumberInRange(0,9);
        if(random_number >= 4) {
            number_go++;
        }
    }

    public String getName() {
        return name;
    }

    public int getGo() {
        return number_go;
    }
}
