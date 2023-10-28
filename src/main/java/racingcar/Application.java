package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        InputGame input = new InputGame();
        input.setCarName();
        input.setGameNumber();

        Game game = new Game();
        game.playGame(input.getCarName(), input.getGameCount());
    }
}
