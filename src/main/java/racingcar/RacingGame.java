package racingcar;

import java.util.List;

public class RacingGame {

    private RacingGameManager gameManager;
    private GameResultMaker gameResultMaker;
    private GameResultView gameResultView;

    public RacingGame(RacingGameManager gameManager, GameResultMaker gameResultMaker, GameResultView gameResultView) {
        this.gameManager = gameManager;
        this.gameResultMaker = gameResultMaker;
        this.gameResultView = gameResultView;
    }

    public void startGame() {
        String userInput = InputManager.getCarNamesFromPlayerInput();
        List<Car> cars = gameManager.createCarListFromPlayerInput(userInput);

        String countInput = InputManager.getCountFromPlayerInput();
        int count = gameManager.createCountFromPlayerInput(countInput);
        System.out.println("실행 결과");

        do {
            gameResultMaker.makeGameResult(cars);
            gameResultView.printGameResult(cars);
        } while (count-- > 1);

        List<String> gameWinner = Car.getRacingGameWinner(cars);
        gameResultView.printGameWinner(gameWinner);
    }
}
