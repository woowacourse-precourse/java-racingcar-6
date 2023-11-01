package racingcar;

import racingcar.domain.controller.MainController;
import racingcar.global.config.DependencyContainer;

public class Application {
    public static void main(String[] args) {
        DependencyContainer dependencyContainer = new DependencyContainer();
        MainController mainController = dependencyContainer.getMainController();
        mainController.startGame();
    }
}
