package racingcar;

public class GameExecutor {
    private RacingCarGame game;
    private InputInterface in;
    private OutputInterface out;

    public GameExecutor() {
        this.in = new InputInterface();
        this.out = new OutputInterface();
    }

    private String[] getNames() {
        out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return in.getNames();
    }

    private int getTrial(){
        out.println("시도할 회수는 몇회인가요?");
        return in.getTrial();
    }

    public void run(GameRandom random) {
        try {
            game = new RacingCarGame(getNames(), getTrial(), out, random);
            game.run();
        } finally {
            in.close();
        }
    }
}
