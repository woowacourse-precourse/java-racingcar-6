package racingcar;

public class RacingCarGame {
    private final InputProcessor inputProcessor;
    private final OutputProcessor outputProcessor;
    private GameBoard gameBoard;
    private Integer repetition;

    public RacingCarGame() {
        inputProcessor = new InputProcessor();
        outputProcessor = new OutputProcessor();
    }

    public void run() {
        initializeGame();
        executeGame();
        showGameResult();
    }

    private void initializeGame() {
        outputProcessor.printCarNameInputMessage();
        this.gameBoard = new GameBoard(inputProcessor.readCarNamesInput());
        outputProcessor.printRepetitionInputMessage();
        this.repetition = inputProcessor.readRepetitionInput();
    }

    private void executeGame() {
        for (int repetitionCount = 0; repetitionCount < repetition; repetitionCount++) {
            gameBoard.processTurn();
            outputProcessor.printMoveResult(gameBoard.getCopyOfPlayerList());
        }
    }

    private void showGameResult() {
        outputProcessor.printWinners(gameBoard.findWinners());
    }
}
