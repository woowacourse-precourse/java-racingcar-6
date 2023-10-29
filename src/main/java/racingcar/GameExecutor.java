package racingcar;

public class GameExecutor {
    private RacingCarGame game;
    private InputInterface in;
    private OutputInterface out;

    public GameExecutor() {
        this.in = new InputInterface();
        this.out = new OutputInterface();
    }

    public void run() {
        try {
            out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] names = in.getNames();
            out.println("시도할 회수는 몇회인가요?");
            int trial = in.getTrial();
            game = new RacingCarGame(trial, names, out);
            out.println("실행 결과");
            game.run();
        } finally {
            in.close();
        }
    }
}
