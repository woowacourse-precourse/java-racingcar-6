package racingcar;

import game.GameRandom;
import java.util.List;

public class FixedGameRandom implements GameRandom {

    private final List<Integer> numbers;
    private int cur = 0;

    FixedGameRandom(List<Integer> list) {
        this.numbers = list;
    }

    private int increaseAndGet() {
        int result = cur;
        cur = (cur + 1) % numbers.size();
        return result;
    }

    private int next() {
        return numbers.get(increaseAndGet());
    }

    @Override
    public int randomNumberRange(int start, int end) {
        return next();
    }
}
