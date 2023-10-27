package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Car {

    static final int MOVE_50_PERCENT = 4;
    private List<String> name;
    private int position;

    public Car(List<String> name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        StringBuilder sb = new StringBuilder();
        for (String s : name) {
            sb.append(s);
        }
        return sb.toString();
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_50_PERCENT;
    }

}