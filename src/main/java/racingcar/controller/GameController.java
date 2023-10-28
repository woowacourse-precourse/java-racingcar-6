package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.GameView;

public class Game {

    private final List<Car> participantCars;
    private final int retryCount;

    public Game(List<Car> participantCars, int retryCount) {
        this.participantCars = participantCars;
        this.retryCount = retryCount;
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

    private List<Car> determineWinner() {
        int maxPosition = 0;
        for (Car participantCar : participantCars) {
            maxPosition = Math.max(maxPosition, participantCar.getPosition());
        }

        int finalMaxPosition = maxPosition;

        List<Car> winners = participantCars.stream()
            .filter(car -> car.getPosition() == finalMaxPosition)
            .toList();

        return winners;
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
            System.out.println(participantCar.getName() + " : " + "-".repeat(position) + "\n");
        }
    }

    private void displayWinner() {
        List<Car> winners = determineWinner();
        List<String> tempWinner = new ArrayList<>();

        for (Car winner : winners) {
            tempWinner.add(winner.getName());
        }

        String winnerNames = String.join(", ", tempWinner);
        GameView.displayFinalWinner(winnerNames);
    }
}