package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameMachine {
    private final RandomNumberGenerator randomNumberGenerator;

    private List<RacingCar> racingCarList = new ArrayList<>();
    private int roundCount;

    public RacingCarGameMachine(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }
}
