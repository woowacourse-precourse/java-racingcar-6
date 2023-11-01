package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Start start = new Start();
        ArrayList<String> names = start.name();
        int times = start.times();
    }
}
