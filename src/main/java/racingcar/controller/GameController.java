package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.GameView;

public class GameController {
    private final GameView gameView;
    private Cars cars;
    private int moveCount;

    public GameController(GameView gameView) {
        this.gameView = gameView;
        this.cars = new Cars();
    }

    public void startGame() {
        getInfoFromUser();
        playRound(moveCount);
        endGame();
    }

    private void getInfoFromUser() {
        gameView.printInputCars();
        String[] carNames = gameView.getUserInput().split(",");
        for (String carName : carNames) {
            cars.insertNewCar(new Car(carName));
        }
        gameView.printInputMoveCount();
        moveCount = Integer.valueOf(gameView.getUserInput());
    }

    private void playRound(int count) {
        gameView.printExecutionStart();
        for (int i = 0; i < count; i++) {
            cars.updateAllDistance();
            List<Car> roundResult = getRoundResult();
            gameView.printMoveResult(roundResult);
        }
    }

    private List<Car> getRoundResult() {
        return cars.getCars();
    }

    private void endGame() {
        List<String> winners = cars.findWinners();
        gameView.printFinalWinner(winners);
    }

}
