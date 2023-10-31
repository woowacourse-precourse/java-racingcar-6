package racingcar.domain;

import static java.util.stream.LongStream.iterate;

import java.util.Map;
import java.util.Set;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Position {

    private Map<String, Integer> position;
    private NumberGenerator numberGenerator;
    private final int FORWARD_CONDITION = 4;
    private final int BACK = -1;

    public Position(Map<String, Integer> carsMaps, int carsGameCount) {
        this.numberGenerator = new RandomNumberGenerator();
        this.position = generatePosition(carsMaps, carsGameCount);
    }

    public Position(Map<String, Integer> carsMaps, int carsGameCount, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.position = generatePosition(carsMaps, carsGameCount);
    }

    private Map<String, Integer> generatePosition(Map<String, Integer> carsMaps, int carsGameCount) {
        Map<String, Integer> initialPosition = carsMaps;
        iterate(0, i -> i + 1).limit(carsGameCount).forEach(i -> calculatePosition(initialPosition));
        return initialPosition;
    }

    private void calculatePosition(Map<String, Integer> initialPosition) {
        Set<String> cars = initialPosition.keySet();
        for (String car : cars) {
            putPosition(initialPosition, car);
        }
    }

    private void putPosition(Map<String, Integer> carsGameResult, String car) {
        if (numberGenerator.generate() < FORWARD_CONDITION) {
            int forward = carsGameResult.get(car) + BACK;
            carsGameResult.put(car, forward);
        }
    }

    public void update(String car, int forward) {
        int newPosition = position.get(car) + forward;
        position.put(car, newPosition);
    }

    public Map<String, Integer> getPosition() {
        return position;
    }
}
