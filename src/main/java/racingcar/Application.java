package racingcar;

import racingcar.global.config.DependencyContainer;
import racingcar.domain.controller.MainController;

public class Application {
    public static void main(String[] args) {
        DependencyContainer dependencyContainer = new DependencyContainer();
        MainController mainController = dependencyContainer.getMainController();
        mainController.startGame();
    }
}
