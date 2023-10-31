package racingcar;


public class Application {
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

    public static void main(String[] args) {
        InputInterface in = new InputInterface();
        OutputInterface out = new OutputInterface();
        RacingCarGame game = new RacingCarGame(in.getNames(), in.getTrial(), getRandom());
        GameExecutor gameExecutor = new GameExecutor(game, in, out);
        gameExecutor.run();
    }
}
