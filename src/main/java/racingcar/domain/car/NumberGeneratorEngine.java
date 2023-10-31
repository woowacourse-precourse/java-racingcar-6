package racingcar.domain.car;

import racingcar.domain.util.NumberGenerator;

public class NumberGeneratorEngine implements CarEngine {
    private static final int MOVE_BOUNDARY = 4;
    private final NumberGenerator generator;

    public NumberGeneratorEngine(NumberGenerator generator) {
        this.generator = generator;
    }

    @Override
    public boolean move() {
        return generator.generate() >= MOVE_BOUNDARY;
    }
}
