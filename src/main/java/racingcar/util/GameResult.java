package racingcar.util;

public class GameResult {

    private StringBuilder gameResult;

    private GameResult() {
        gameResult = new StringBuilder();
    }

    private static class SingletonHelper {
        private static final GameResult INSTANCE = new GameResult();
    }

    public static GameResult getInstance() {
        return GameResult.SingletonHelper.INSTANCE;
    }

    public StringBuilder getGameResult() {
        return gameResult;
    }
}
