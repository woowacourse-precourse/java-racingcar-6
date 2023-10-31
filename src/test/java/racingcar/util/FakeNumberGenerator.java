package racingcar.util;

import racingcar.domain.generator.NumberGenerator;

public class FakeNumberGenerator implements NumberGenerator {
    private final int expectedNumber;

    public FakeNumberGenerator(int expectedNumber) {
        this.expectedNumber = expectedNumber;
    }

    @Override
    public int generate() {
        return expectedNumber;
    }
}