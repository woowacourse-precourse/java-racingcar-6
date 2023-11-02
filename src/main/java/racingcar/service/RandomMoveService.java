package racingcar.service;

import racingcar.service.generator.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.global.GameConfig.MAGIC_NUMBER;

public class RandomMoveService implements MoveService {
    private final RandomGenerator randomGenerator;

    public RandomMoveService(RandomGenerator randomGenerator) {
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
