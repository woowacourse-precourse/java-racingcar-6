package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String car_name;
    private int length;
    public Car(String car_name) {
        this.car_name = car_name;
        this.length = 0;
    }

    public void moveCar() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            length++;
        };
    }

    public void printLocation() {
        String builder = car_name
                + " : "
                + "-".repeat(Math.max(0, length));

        System.out.println(builder);
    }

    public int getLength() {
        return length;
    }
}
