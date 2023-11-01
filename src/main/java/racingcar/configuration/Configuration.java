package racingcar.configuration;

import static racingcar.game.TextResourceManager.GAME_STAGE_VIEW_HEADER;
import static racingcar.game.TextResourceManager.GAME_WINNER_VIEW_TAG;

import camp.nextstep.edu.missionutils.Console;
import game.GameExecutor;
import game.GameRandom;
import racingcar.game.InputInterface;
import racingcar.game.MissionUtilsGameRandom;
import racingcar.game.OutputInterface;
import racingcar.game.RacingCarGame;
import racingcar.game.renderer.RacingCarGameRenderer;
import racingcar.game.renderer.SimpleRacingCarGameRenderer;
import racingcar.game.view.SimpleHeaderView;
import racingcar.game.view.SimpleTagView;
import racingcar.game.view.View;

public class Configuration {
    private static GameRandom random;

    private static GameRandom getRandom() {
        if (random == null) {
            random = new MissionUtilsGameRandom();
        }
        return random;
    }

    public static void setRandom(GameRandom newRandom) {
        random = newRandom;
    }

    public static GameExecutor getGameExecutor() {
        RacingCarGameRenderer renderer = new SimpleRacingCarGameRenderer();
        View gameStageView = new SimpleHeaderView(System.out::println, GAME_STAGE_VIEW_HEADER);
        View gameWinnerView = new SimpleTagView(System.out::println, GAME_WINNER_VIEW_TAG);
        InputInterface in = new InputInterface(Console::readLine, System.out::println);
        OutputInterface out = new OutputInterface(System.out::println,gameStageView,gameWinnerView);
        RacingCarGame game = new RacingCarGame(in, out, getRandom(), renderer);
        return new GameExecutor(game);
    }


}
