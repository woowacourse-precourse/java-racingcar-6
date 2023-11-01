package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Start start = new Start();
        Move move = new Move();

        ArrayList<String> names = start.name();
        int times = start.times();

        move.move(names, times);
    }
}
