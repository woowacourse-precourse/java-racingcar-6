package racingcar.dto.input;

import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;

public final class InputDTO {
    private final TrialCount trialCount;
    private final Names names;

    private InputDTO(TrialCount trialCount, Names names) {
        this.trialCount = trialCount;
        this.names = names;
    }

    public static InputDTO of(TrialCount trialCount, Names names) {
        return new InputDTO(trialCount, names);
    }

    public TrialCount getTrialCount() {
        return trialCount;
    }

    public Names getNames() {
        return names;
    }
}
