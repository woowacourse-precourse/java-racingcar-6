package racingcar;

// file:///Users/mac/Desktop/woowacourse/woowacourse-precourse-week2/build/reports/tests/test/classes/racingcar.ApplicationTest.html

import controller.Controller;

public class Application {

    private final static Controller controller = Controller.getInstance();

    public static void main(String[] args) {
        controller.playGame();
    }
}
