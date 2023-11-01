package racingcar.stub;

import racingcar.domain.NumberGenerator;

public class StubNumberGenerator implements NumberGenerator {
    @Override
    public int pickNumberInRange(int startInclusive, int endExclusive) {
        return 9;
    }
}
