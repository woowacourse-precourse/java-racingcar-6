package racingcar.domain;

import static racingcar.constant.DomainConstant.EXTRACT_TRACK_DECREASE;
import static racingcar.constant.DomainConstant.EXTRACT_TRACK_MIN_SIZE;
import static racingcar.exception.DomainExceptionCode.EXTRACT_TRACK_MUST_BE_GRATER_THAN_ZERO;

public record ExtractTrack(int value) {

    public ExtractTrack {
        EXTRACT_TRACK_MUST_BE_GRATER_THAN_ZERO.dynamicInvokeBy(() -> value < EXTRACT_TRACK_MIN_SIZE.getValue());
    }


    public ExtractTrack consumerCount() {
        return new ExtractTrack(value - EXTRACT_TRACK_DECREASE.getValue());
    }

    public boolean isCompleted() {
        return value == EXTRACT_TRACK_MIN_SIZE.getValue();
    }

}
