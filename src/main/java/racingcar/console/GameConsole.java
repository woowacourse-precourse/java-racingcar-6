package racingcar.console;

import racingcar.console.game.Game;
import racingcar.console.game.GameList;
import racingcar.console.game.racingcar.RacingCarGame;

public class GameConsole {

    private GameList targetGameName;
    private Game targetGame;

    public GameConsole() {
        init();
    }

    public GameConsole(Game game) {
        init();
        targetGame = game;
    }

    private void init() {
        setDefaultTarget(GameList.RACING_CAR);
    }
    private void setDefaultTarget(GameList defaultTargetGameName) {
        this.targetGameName = defaultTargetGameName;
    }

    public Game start() {
        targetGame = loadTargetGame();
        if (targetGame != null) {
            targetGame.start();
        }
        return targetGame;
    }

    private Game loadTargetGame() {
        return GameFactory.load(targetGameName);
    }

    public static class GameFactory {
        public static Game load(GameList targetGameName) {
            return switch (targetGameName) {
                case RACING_CAR -> new RacingCarGame();
                // 다른 게임들도 추가
                default -> null;
            };
        }
    }

}
