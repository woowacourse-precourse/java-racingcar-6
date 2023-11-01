package racingcar;

import racingcar.controller.CarController;

public class Application {
    static private final CarController controller = new CarController();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        controller.race();
    }
}
