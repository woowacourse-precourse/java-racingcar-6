package racingcar;

import racingcar.domain.MainCarGame;
import racingcar.domain2.MainController;

public class Application {
    public static void main(String[] args) {
        MainCarGame mainCarGame = new MainCarGame();
        mainCarGame.gameStart();
    }
}
