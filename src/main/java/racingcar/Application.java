package racingcar;

import racingcar.controller.Gamecontroller;

public class Application {
    private final Gamecontroller gamecontroller = new Gamecontroller();
    public static void main(String[] args) {
        Gamecontroller.start();
    }
}
