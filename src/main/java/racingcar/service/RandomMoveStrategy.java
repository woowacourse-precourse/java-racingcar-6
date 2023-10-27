package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomMoveStrategy implements MoveStrategy{
    private final int totalMoves;

    public RandomMoveStrategy(int totalMoves) {
        this.totalMoves = totalMoves;
    }

    @Override
    public List<Boolean> createMovementFlags() {
        return IntStream.range(0, totalMoves)
                .mapToObj(i->decideMovement())
                .collect(Collectors.toList());
    }

    private Boolean decideMovement(){
        int randomNumber = Randoms.pickNumberInRange(1,9);
        return randomNumber >= 4;
    }
}
