package racingcar.model;

import racingcar.view.OutputView;

public class RacingGame {

    private final Cars cars;
    private final RaceCountInput raceCountInput;

    public RacingGame(Cars cars, RaceCountInput raceCountInput) {
        this.cars = cars;
        this.raceCountInput = raceCountInput;
    }

    public void startGame() {
        for (int i = 0; i < raceCountInput.getRaceCount(); i++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars.getCars()) {
            if (getRandomNumber() >= 4) {
                car.move();
            }
            printCurrent(car);
        }
    }

    private static int getRandomNumber() {
        RandomNumberGenerator numberGenerator = RandomNumberGenerator.createNumberGenerator();
        return numberGenerator.getRandomNumber();
    }

    private static void printCurrentLocation(String name, int currentNum) {
        OutputView.currentLocation(name, currentNum);
    }

    private static void printCurrent(Car car) {
        String name = car.getName();
        int currentNum = car.getCurrentLocation();
        printCurrentLocation(name, currentNum);
    }
}
