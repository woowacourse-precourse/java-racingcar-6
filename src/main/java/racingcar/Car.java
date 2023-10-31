package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {

    int position = 0;

    public Car(String name) {
    }
    
    public boolean canMove() {
        List<Integer> numbers = generateRandomNumbers();
        return true;
    }

    private List<Integer> generateRandomNumbers() {
        return new ArrayList<>();
    }

    public void move() {
    }

    public int getPosition() {
        return position;
    }
}
