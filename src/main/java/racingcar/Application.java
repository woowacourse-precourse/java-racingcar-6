package racingcar;

public class Application {
    public static void main(String[] args) {
        GameUtil gameUtil = new GameUtil(Constants.MIN_RANDOM_VALUE, Constants.MAX_RANDOM_VALUE);

        gameUtil.runGame();
    }
}
