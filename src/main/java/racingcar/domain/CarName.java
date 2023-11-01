package racingcar.domain;

import static racingcar.exception.DomainExceptionCode.CAR_NAME_CAN_NOT_BE_EMPTY;
import static racingcar.exception.DomainExceptionCode.CAR_NAME_SIZE_MUST_BE_LESS_THAN_EQUAL;

import java.util.Objects;
import racingcar.constant.DomainConstant;

public record CarName(String value) {
    public CarName {
        CAR_NAME_CAN_NOT_BE_EMPTY.dynamicInvokeBy(() -> Objects.isNull(value) || value.isBlank());
        CAR_NAME_SIZE_MUST_BE_LESS_THAN_EQUAL.dynamicInvokeBy(() -> value.length() > DomainConstant.CAR_NAME_SIZE.getValue());
    }

}
