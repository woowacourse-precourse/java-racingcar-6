package racingcar;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> status = Input.getInitialStatus();
        int count = Input.getCount();
        status = Game.play(status, count);
        Result.showFinal(status);
    }
}
