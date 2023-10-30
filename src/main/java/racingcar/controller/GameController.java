package racingcar.controller;

import static racingcar.model.Car.createNewCar;
import static racingcar.model.Cars.createNewCars;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.GameView;

public class GameController {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MIN_MOVE_COUNT = 1;
    private static final int MAX_MOVE_COUNT = 10;
    private static final String MOVE_COUNT_RANGE_ERROR_MESSAGE = "이동 횟수는 10 이하의 자연수여야 함";

    private final GameView gameView;
    private Cars cars;
    private int moveCount;

    public GameController(GameView gameView) {
        this.gameView = gameView;
        this.cars = createNewCars();
    }

    public void startGame() {
        getInfoFromUser();
        playRound(moveCount);
        endGame();
    }

    private void getInfoFromUser() {
        gameView.printInputCars();
        saveUserInputOnCars();
        gameView.printInputMoveCount();
        saveUserInputOnMoveCount();
    }

    private void saveUserInputOnCars() {
        Arrays.stream(gameView.getUserInput().split(CAR_NAME_DELIMITER))
                .forEach(carName -> cars.insert(createNewCar(carName.trim())));
    }

    private void saveUserInputOnMoveCount() {
        int userInput = Integer.valueOf(gameView.getUserInput());
        if (!validateMoveCount(userInput)) {
            throw new IllegalArgumentException(MOVE_COUNT_RANGE_ERROR_MESSAGE);
        }
        moveCount = userInput;
    }

    private boolean validateMoveCount(int count) {
        return count >= MIN_MOVE_COUNT && count <= MAX_MOVE_COUNT;
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
