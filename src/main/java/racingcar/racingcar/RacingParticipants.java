package racingcar.racingcar;

import java.util.List;

/**
 * @author 민경수
 * @description racing car
 * @since 2023.10.27
 **********************************************************************************************************************/
public record RacingParticipants(List<String> participantNames) {

    public RacingParticipants {
        validateParticipantsCount(participantNames);

    }

    private void validateParticipantsCount(List<String> participantNames) {
        if (participantNames.size() == 0) {
            throw new IllegalArgumentException("레이싱 참가자를 최소 1명 입력해주세요.");
        }
    }
    
}