package racingcar;

// file:///Users/mac/Desktop/woowacourse/woowacourse-precourse-week2/build/reports/tests/test/classes/racingcar.ApplicationTest.html

import Presenter.Presenter;

public class Application {

    private final static Presenter controller = Presenter.getInstance();

    public static void main(String[] args) {
        controller.playGame();
    }
}
