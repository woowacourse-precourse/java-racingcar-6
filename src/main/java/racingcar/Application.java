package racingcar;

import camp.nextstep.edu.missionutils.Console;
import game.GameExecutor;
import game.GameRandom;
import racingcar.configuration.Configuration;
import racingcar.game.InputInterface;
import racingcar.game.MissionUtilsGameRandom;
import racingcar.game.OutputInterface;
import racingcar.game.RacingCarGame;
import racingcar.game.renderer.RacingCarGameRenderer;
import racingcar.game.renderer.SimpleRacingCarGameRenderer;

public class Application {

    public static void main(String[] args) {
        GameExecutor gameExecutor = Configuration.getGameExecutor();
        gameExecutor.run();
    }
}
