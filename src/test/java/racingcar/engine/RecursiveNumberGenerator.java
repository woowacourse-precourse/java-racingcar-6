package racingcar.engine;

import racingcar.generator.NumberGenerator;

import java.util.List;

public class RecursiveNumberGenerator implements NumberGenerator {
    private final List<Integer> list;
    private int index;

    public RecursiveNumberGenerator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public int generate(int startInclusive, int endInclusive) {
        return list.get(getIndex());
    }

    private int getIndex() {
        int returnValue = index;
        index++;
        index %= list.size();
        return returnValue;
    }
}
