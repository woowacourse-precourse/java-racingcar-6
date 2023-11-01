package racingcar;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carNames = inputView.askCarNames();
        int tryCount = inputView.askTryCount();

        Game game = new Game(carNames);

        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            game.playRound();
            outputView.printRoundResult(game.getCars());
        }
        outputView.printFinalResult(game.findWinners());
    }
}
