package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        int num = Randoms.pickNumberInRange(0, 9);
        if(num >= 4) {
            position++;
        }
    }
}
