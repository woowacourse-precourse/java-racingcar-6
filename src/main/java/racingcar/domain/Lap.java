package racingcar.domain;

import static racingcar.exception.DomainExceptionCode.LAP_MUST_BE_GREATER_THAN_ZERO;

import racingcar.constant.DomainConstant;

public record Lap(int count) {

    public Lap {
        LAP_MUST_BE_GREATER_THAN_ZERO.dynamicInvokeBy(() -> DomainConstant.LAP_MIN_SIZE.getValue() > count);
    }

    public Lap nextLap() {
        return new Lap(count + DomainConstant.LAP_INCREASE_COUNT.getValue());
    }

}
