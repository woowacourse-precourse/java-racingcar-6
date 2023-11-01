package racingcar.domain.strategy;

import java.util.Arrays;
import java.util.function.Supplier;

public enum MovingStrategyType {
    RANDOM(RandomMovingStrategy::instance);

    private final Supplier<MovingStrategy> supplier;

    MovingStrategyType(Supplier<MovingStrategy> supplier) {
        this.supplier = supplier;
    }

    public static MovingStrategy instance(MovingStrategyType givenType) {
        return Arrays.stream(values())
                .filter(type -> type.equals(givenType))
                .findAny()
                .map(MovingStrategyType::get)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 MovingStrategy 타입입니다."));
    }

    private MovingStrategy get() {
        return supplier.get();
    }
}
