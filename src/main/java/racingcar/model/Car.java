package racingcar.model;
import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private final String name;
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

    public void move() {
        int move = Randoms.pickNumberInRange(0,9);
        if (move >= 4) {
            position++;
        }
    }
}
