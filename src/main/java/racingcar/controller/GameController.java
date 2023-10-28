package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

        displayWinner();
    }

    private void tryRoundUntilRetryCount() {
        for (int i = 0; i < retryCount; i++) {
            moveCar();
            displayCarPosition();
        }
    }

    private void moveCar() {
        for (Car car : participantCars) {
            if (isMoveToForward()) {
                car.move();
            }
        }
    }

    private boolean isMoveToForward() {
        return getRandomNumber() >= 4;
    }

    private int getRandomNumber() {
        return new RandomNumber().getNumber();
    }

    private void displayCarPosition() {
        for (Car participantCar : participantCars) {
            int position = participantCar.getPosition();
            System.out.println(participantCar.getName() + " : " + "-".repeat(position));
        }
    }

    private void displayWinner() {
        List<Car> winners = game.getWinnerList();
        GameView.displayFinalWinner(game.getWinnerNames(winners));
    }
}