package racingcar;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Player player = new Player();
        GameService gameService = new GameService();

        GameController gameController = new GameController(inputView, outputView, player, gameService);
        gameController.play();
    }
}
