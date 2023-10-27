package racingcar;

import racingcar.container.ApplicationContainer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new ApplicationContainer().getRaceController().run();
    }
}
