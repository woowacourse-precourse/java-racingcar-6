package Model;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int move = Randoms.pickNumberInRange(0,9);
        if (move >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
    public String getDistance() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < position; i++) {
            s.append("-");
        }
        return s.toString();
    }

}

