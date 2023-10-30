package racingcar.domain;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.position++;
        }
    }
}
