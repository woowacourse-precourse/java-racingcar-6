package racingcar.controller;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        startGame();
        playGame();
        endGame();
    }

    public void startGame() {
        inputView.carName();
        isCorrectName();
        inputView.tryGame();
        isCorrectNumber();
        carGenerator();
    }

    public void playGame() {
        moveCar();
        showRoundResult();
    }

    public void endGame(){
        findWinner();
        showWinner();
    }
}
