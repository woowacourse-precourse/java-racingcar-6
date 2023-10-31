package racingcar.dto.input;

import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;

public record InputDTO(TrialCount trialCount, Names names) {
    public static InputDTO of(TrialCount trialCount, Names names) {
        return new InputDTO(trialCount, names);
    }
}
