package racingcar;

import racingcar.config.DependencyContainer;
import racingcar.controller.MainController;

public class Application {
    public static void main(String[] args) {
        DependencyContainer dependencyContainer = new DependencyContainer();
        MainController mainController = dependencyContainer.getMainController();
        mainController.startGame();
    }
}
