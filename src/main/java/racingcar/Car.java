package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {

    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;
    private final int MOVE_MIN_NUMBER = 4;

    int position = 0;

    public Car(String name) {
    }
    
    public boolean canMove() {
        return generateRandomNumber() > MOVE_MIN_NUMBER;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
