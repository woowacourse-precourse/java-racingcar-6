package racingcar.constant;

import java.util.function.Consumer;
import racingcar.exception.DomainExceptionCode;

public enum DomainConstant {
    LAP_MIN_SIZE(0),
    LAP_INCREASE_COUNT(1);

    private final int value;

    DomainConstant(int value) {
        this.value = value;
    }


    public Consumer<DomainExceptionCode> isLessThan(int other) {
        return (domainExceptionCode) -> {
            if (this.value < other) {
                throw domainExceptionCode.invoke();
            }
        };
    }

    public Consumer<DomainExceptionCode> isGreaterThan(int other) {
        return (domainExceptionCode) -> {
            if (this.value > other) {
                throw domainExceptionCode.invoke();
            }
        };
    }

    public int getValue() {
        return value;
    }
}
