package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private RacingGameView racingGameView;

    public RacingGame() {
        this.racingGameView = new RacingGameView();
    }

    public void start() {
        List<RacingCar> racingCars = new ArrayList<>();
        List<String> carNames = racingGameView.inputCarNames();
        int gameRounds = racingGameView.inputGameRounds();

        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }

        for (int i = 0; i < gameRounds; i++) {
            for (RacingCar car : racingCars) {
                car.move();
            }

            racingGameView.printRoundResult(racingCars);
        }

        int maxLength = 0;
        List<RacingCar> winners = new ArrayList<>();

        for (RacingCar car : racingCars) {
            String movement = car.getMovement();
            int length = movement.length();
            if (length > maxLength) {
                maxLength = length;
                winners.clear();
                winners.add(car);
            } else if (length == maxLength) {
                winners.add(car);
            }
        }

        racingGameView.printWinners(winners);
    }
}
