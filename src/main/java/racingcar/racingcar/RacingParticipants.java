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
        validateParticipantsNameLength(participantNames);

    }

    private void validateParticipantsCount(List<String> participantNames) {
        if (participantNames.size() == 0) {
            throw new IllegalArgumentException("레이싱 참가자를 최소 1명 입력해주세요.");
        }
    }


    private void validateParticipantsNameLength(List<String> participantNames) {
        for (String participantName : participantNames) {
            if (participantName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 공백 포함 5글자를 초과할 수 없습니다. 이름을 확인해주세요. 입력한 이름 : " + participantName);
            }
        }
    }

}