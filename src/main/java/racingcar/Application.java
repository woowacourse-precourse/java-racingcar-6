package racingcar;

import racingcar.controller.Race_Controller;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        Race_Controller race = new Race_Controller();
        race.start();
    }
}
