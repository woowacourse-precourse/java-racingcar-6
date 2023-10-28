package racingcar.domain;

import java.util.List;
import racingcar.domain.generator.NumberGenerator;

class RacingCarTest {

    static class FakeNumberGenerator implements NumberGenerator {
        private final int expectedNumber;

        public FakeNumberGenerator(int expectedNumber) {
            this.expectedNumber = expectedNumber;
        }

        @Override
        public int generate() {
            return expectedNumber;
        }
    }
}
