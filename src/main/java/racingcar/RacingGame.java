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
        List<Car> cars = getCarList();
        int count = getCount();
        gameResultView.printConsole();
        do {
            printGameResult(cars);
        } while (count-- > 1);
        printGameWinner(cars);
    }

    private List<Car> getCarList() {
        String userInput = InputManager.getCarNamesFromPlayerInput();
        List<Car> cars = gameManager.createCarListFromPlayerInput(userInput);
        return cars;
    }

    private int getCount() {
        String countInput = InputManager.getCountFromPlayerInput();
        int count = gameManager.createCountFromPlayerInput(countInput);
        return count;
    }

    private void printGameResult(List<Car> cars) {
        gameResultMaker.makeGameResult(cars);
        gameResultView.printGameResult(cars);
    }

    private void printGameWinner(List<Car> cars) {
        List<String> gameWinner = Car.getRacingGameWinner(cars);
        gameResultView.printGameWinner(gameWinner);
    }
}