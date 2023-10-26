package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final RacingGameView racingGameView;

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
        playRounds(gameRounds, racingCars);
        racingGameView.printWinners(getWinners(racingCars));
    }

    private List<RacingCar> getWinners(List<RacingCar> racingCars) {
        int maxLength = racingCars.stream()
                .mapToInt(car -> car.getMovement().length())
                .max()
                .orElse(0);

        return racingCars.stream()
                .filter(car -> car.getMovement().length() == maxLength)
                .collect(Collectors.toList());
    }

    private void playRounds(int gameRounds, List<RacingCar> racingCars) {
        racingGameView.printResultMessage();
        for (int round = 0; round < gameRounds; round++) {
            moveCars(racingCars);
            racingGameView.printRoundResult(racingCars);
        }
    }

    private void moveCars(List<RacingCar> racingCars) {
        racingCars.forEach(RacingCar::move);
    }
}
