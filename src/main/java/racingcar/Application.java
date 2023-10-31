package racingcar;

import racingcar.manager.controller.ManagerController;
import racingcar.manager.model.Manager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ManagerController managerController = new ManagerController();
        managerController.run();
    }
}
