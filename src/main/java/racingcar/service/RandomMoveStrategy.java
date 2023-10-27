package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomMoveStrategy implements MoveStrategy{
    private final int totalMoves;
    private final RandomGenerator randomGenerator;

    public RandomMoveStrategy(int totalMoves, RandomGenerator randomGenerator) {
        this.totalMoves = totalMoves;
        this.randomGenerator = randomGenerator;
    }

    @Override
    public List<Boolean> createMovementFlags() {
        return IntStream.range(0, totalMoves)
                .mapToObj(i->decideMovement())
                .collect(Collectors.toList());
    }

    private Boolean decideMovement(){
        int randomNumber = randomGenerator.generate();
        return randomNumber >= 4;
    }
}
