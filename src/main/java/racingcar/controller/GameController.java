package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.model.RandomNumber;
import racingcar.view.GameView;

public class GameController {

    private final List<Car> participantCars;
    private final int retryCount;
    private final Game game;

    public GameController(List<Car> participantCars, int retryCount, Game game) {
        this.participantCars = participantCars;
        this.retryCount = retryCount;
        this.game = game;
    }

    public void playGame() {
        GameView.displayResultMessage();
        tryRoundUntilRetryCount();

        GameView.displayFinalWinner(game.getWinnerNames(game.getWinnerList()));
    }

    private void tryRoundUntilRetryCount() {
        for (int i = 0; i < retryCount; i++) {
            moveCar();
            displayCarPosition();
        }
    }

    private void moveCar() {
        for (Car car : participantCars) {
            if (game.isCarMoveToForward()) {
                car.move();
            }
        }
    }

    private void displayCarPosition() {
        for (Car participantCar : participantCars) {
            String positionBar = getPositionBarByCar(participantCar);

            System.out.println(positionBar);
        }
    }

    private static String getPositionBarByCar(Car participantCar) {
        int position = participantCar.getPosition();
        String positionBar = String.format("%s : %s", participantCar.getName(),
            "-".repeat(position));
        return positionBar;
    }
}