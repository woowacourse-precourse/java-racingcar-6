package racingcar;

import racingcar.Controller.Controller;
import racingcar.Domain.ProgressBoard;
import racingcar.Service.Service;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new Service(ProgressBoard.getInstance()));
        controller.run();
    }
}
