package racingcar.model;

import java.util.List;
import racingcar.view.OutputView;

public class RacingGame {

    private static final int FORWARD = 4;
    private final Cars cars;
    private final RaceCountInput raceCountInput;

    public RacingGame(Cars cars, RaceCountInput raceCountInput) {
        this.cars = cars;
        this.raceCountInput = raceCountInput;
    }

    public void startGame() {
        System.out.println();
        for (int i = 0; i < raceCountInput.getRaceCount(); i++) {
            playRound();
            displayRoundResults();
        }
        printWinner();
    }

    private void playRound() {
        for (Car car : cars.getCars()) {

            if (getRandomNumber() >= FORWARD) {
                car.move();
            }
        }
    }

    private void displayRoundResults() {
        for (Car car : cars.getCars()) {
            printCurrent(car);
        }
        System.out.println();
    }

    private static int getRandomNumber() {
        RandomNumberGenerator numberGenerator = RandomNumberGenerator.createNumberGenerator();
        return numberGenerator.getRandomNumber();
    }

    private static void printCurrent(Car car) {
        String name = car.getName();
        int currentNum = car.getCurrentLocation();
        OutputView.currentLocation(name, currentNum);
    }

    private void printWinner() {
        List<Car> winners = cars.findWinners();
        OutputView.announceWinners(winners);
    }
}
