package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.global.GameIntConstant.MAGIC_NUMBER;

public class RandomMoveStrategy implements MoveStrategy {
    private final RandomGenerator randomGenerator;

    public RandomMoveStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public List<Boolean> createMovementFlags(int triesCount) {
        return IntStream.range(0, triesCount)
                .mapToObj(i -> decideMovement())
                .collect(Collectors.toList());
    }

    private Boolean decideMovement() {
        int randomNumber = randomGenerator.generate();
        return randomNumber >= MAGIC_NUMBER.getValue();
    }
}
