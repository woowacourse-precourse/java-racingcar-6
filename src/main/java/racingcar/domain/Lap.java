package racingcar.domain;

import racingcar.constant.DomainConstant;
import racingcar.exception.DomainExceptionCode;

public record Lap(int count) {

    public Lap {
        // lap의 최소치가 현재 카운트보다 크다면 [lap은 0보다 커야하는 에러를 발생시킨다]
        DomainConstant.LAP_MIN_SIZE.isGreaterThan(count)
                .accept(DomainExceptionCode.LAP_MUST_BE_GREATER_THAN_ZERO);
    }

    public Lap nextLap() {
        return new Lap(count + DomainConstant.LAP_INCREASE_COUNT.getValue());
    }

}
