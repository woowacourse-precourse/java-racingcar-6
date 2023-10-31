package racingcar;

public class GameExecutor {
    private RacingCarGame game;
    private InputInterface in;
    private OutputInterface out;

    public GameExecutor() {
        this.in = new InputInterface();
        this.out = new OutputInterface();
    }

    public void run(GameRandom random) {
        try {
            game = new RacingCarGame(in.getNames(), in.getTrial(), out, random);
            game.run();
        } finally {
            in.close();
        }
    }
}
