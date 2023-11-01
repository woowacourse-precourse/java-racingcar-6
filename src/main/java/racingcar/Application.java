package racingcar;

import game.GameExecutor;
import racingcar.configuration.Configuration;


public class Application {

    public static void main(String[] args) {
        GameExecutor gameExecutor = Configuration.getGameExecutor();
        gameExecutor.run();
    }
}
