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
            game = new RacingCarGame(in.getNames(), in.getTrial(),  random);
            out.println("실행 결과");
            while(!game.isFinished()){
                game.runStage();
                out.printStage(game);
            }
            out.printWinners(game.getWinners());
        } finally {
            in.close();
        }
    }
}
