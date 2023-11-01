package racingcar;

import racingcar.component.ComponentFactory;

public class Application {
    public static void main(String[] args) {
        final ComponentFactory componentFactory = new ComponentFactory();
        componentFactory.racingCarController().play();
    }
}
