package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final int round;
    private final Referee referee;

    public RacingGame(List<String> racingCarNames, int round,
            RandomNumberGenerator randomNumberGenerator) {
        this.racingCars = racingCarNames.stream().map(RacingCar::new).collect(Collectors.toList());
        this.round = round;
        this.referee = new Referee(randomNumberGenerator);
    }

    public void play() {
        for (int i = 0; i < round; i++) {
            referee.playRound(racingCars);
            RacingGameDisplay.displayRaceStatus(racingCars);
        }
    }

    public List<String> getWinners() {
        return referee.getWinners(racingCars).stream().map(RacingCar::getName)
                .collect(Collectors.toList());
    }

}
