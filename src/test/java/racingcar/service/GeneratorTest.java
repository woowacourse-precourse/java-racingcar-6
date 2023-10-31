package racingcar.service;

import racingcar.constant.Rule;

public class GeneratorTest {
    public static class MoveNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return Rule.MAX_POSSIBILITY;
        }
    }

    public static class CanNotMoveNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return Rule.MIN_POSSIBILITY;
        }
    }
}
