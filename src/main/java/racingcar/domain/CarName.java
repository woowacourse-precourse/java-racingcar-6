package racingcar.domain;

import racingcar.exception.DomainExceptionCode;

public record CarName(String value) {
    public CarName {
        DomainExceptionCode.CAR_NAME_CAN_NOT_BE_EMPTY.dynamicInvoke(() -> value == null || value.isEmpty());
        DomainExceptionCode.CAR_NAME_MUST_BE_LESS_THAN_EQUAL.dynamicInvoke(() -> value.length() > 5);
    }
}
