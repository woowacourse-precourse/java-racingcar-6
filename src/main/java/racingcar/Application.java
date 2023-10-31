package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.view.RacingGameException;

public class Application {
    public static void main(String[] args) {
        try {
            new RacingCarGame().run();
        } catch (RacingGameException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
