package generator;

import racingcar.util.Generator;

public class NumberGenerator implements Generator {
    private final int number;

    public NumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return this.number;
    }
}
