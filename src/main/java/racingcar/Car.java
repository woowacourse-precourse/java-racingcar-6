package racingcar;

import java.util.List;

public class Car {
    String name;
    int move;

    public Car(String name, int move) {
        this.name = name;
        this.move = move;
    }

    public String result() {
        String dash = "-".repeat(move);

        String result = String.format("%s : %s%n", name, dash);

        return result;
    }
}
