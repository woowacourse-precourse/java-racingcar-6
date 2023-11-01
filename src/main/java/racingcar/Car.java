package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Car {

    static final int MOVE_60_PERCENT = 4;
    private List<String> name;
    private int position;

    public Car(List<String> name) {
        this.name = name;
        this.position = 0;
    }

    public Car(List<String> name, int position) {
        this.name = name;
        this.position = position;
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

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_60_PERCENT;
    }

}