package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.entity.Car;

public class RacingGame {

    public enum RacingGameState {
        READY_TO_START, RUNNING, RESULT_READY
    }

    // Game Configuration fields
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int THRESHOLD = 4;

    private RacingGameState state;

    private List<Car> cars;

    private int remainingRounds;

    protected RacingGame(String[] names, int rounds) {
        this.state = RacingGameState.READY_TO_START;
        this.cars = new ArrayList<>();
        List.of(names).forEach(n -> cars.add(new Car(n)));
        this.remainingRounds = rounds;
    }

    protected void tryToProceedCars() {
        cars.stream()
                .filter(c -> isOverThreshold(generateRandomIntInRange()))
                .forEach(c -> c.proceedSingleUnit());
    }
    private int generateRandomIntInRange() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }

    private boolean isOverThreshold(int generatedInt) {
        return generatedInt >= THRESHOLD;
    }
}
