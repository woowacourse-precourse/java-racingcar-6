package racingcar;

import racingcar.controller.GameController;
import racingcar.handler.UserInputHandler;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> nameList = UserInputHandler.getNamesFromUser();
        String names = String.join(", ", nameList);

        GameController gameController = new GameController();
        gameController.setUp(names);
    }
}
