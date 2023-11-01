package racingcar.game;

import java.util.List;
import racingcar.model.RacingCar;

public class RacingGame {
    private final List<RacingCar> racingCars;
    private final int endLap;

    public RacingGame(List<RacingCar> racingCars, int endLap) {
        this.racingCars = racingCars;
        this.endLap = endLap;
    }

    public void run() {
        System.out.println("실행 결과");
    }
}
