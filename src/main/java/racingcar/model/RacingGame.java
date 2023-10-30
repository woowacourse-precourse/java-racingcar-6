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
            String name = car.getName();
            int currentLocation = car.getCurrentLocation();
            System.out.println(name + " :" + currentLocation);
        }

        System.out.println();
        System.out.println();
    }

    public static int getRandomNumber() {
        RandomNumberGenerator numberGenerator = RandomNumberGenerator.createNumberGenerator();
        return numberGenerator.getRandomNumber();
    }
}
