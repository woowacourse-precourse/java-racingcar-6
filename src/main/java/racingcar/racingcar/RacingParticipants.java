package racingcar.racingcar;

import java.util.List;

/**
 * @author 민경수
 * @description racing car
 * @since 2023.10.27
 **********************************************************************************************************************/
public class RacingParticipants {

    private final List<String> participantNames;

    public RacingParticipants(List<String> participantNames) {
        this.participantNames = participantNames;
    }

    public List<String> getParticipantNames() {
        return this.participantNames;
    }
}