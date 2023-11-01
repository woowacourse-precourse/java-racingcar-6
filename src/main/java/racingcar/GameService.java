package racingcar;

import java.util.List;

public class GameService {

    private final RacingCars racingCars;
    private final AttemptNumber attemptNumber;

    public GameService(RacingCars racingCars, AttemptNumber attemptNumber) {
        this.racingCars = racingCars;
        this.attemptNumber = attemptNumber;
    }

    public void start() {
        for (int i = 0; i < this.attemptNumber.getCount(); i++) {
            this.racingCars.allCarMove();
            System.out.println();
        }
    }
}
