package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import static racingcar.Vars.MIN_RANDOM_NUMBER;
import static racingcar.Vars.MAX_RANDOM_NUMBER;


public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(String[] carNames, int rounds) {
        this.rounds = rounds;
        this.cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
    }

}
