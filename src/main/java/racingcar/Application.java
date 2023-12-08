package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        controller.startGame();
        controller.makeCar();
        controller.setCarMove();
        controller.setWinner();
    }
}
