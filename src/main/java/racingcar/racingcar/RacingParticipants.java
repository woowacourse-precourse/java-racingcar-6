package racingcar.racingcar;

import java.util.List;

/**
 * @author 민경수
 * @description racing car
 * @since 2023.10.27
 **********************************************************************************************************************/
public record RacingParticipants(List<String> participantNames) {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_PARTICIPANTS = 1;

    public RacingParticipants {
        validateParticipantsCount(participantNames);
        validateParticipantsNameLength(participantNames);
    }

    private void validateParticipantsCount(List<String> participantNames) {
        if (participantNames.size() < MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException("레이싱 참가자를 최소 1명 입력해주세요.");
        }
    }


    private void validateParticipantsNameLength(List<String> participantNames) {
        for (String participantName : participantNames) {
            checkParticipantName(participantName);
        }
    }

    private void checkParticipantName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "자동차 이름은 공백 포함 " + MAX_NAME_LENGTH + "글자를 초과할 수 없습니다. 이름을 확인해주세요. 입력한 이름 : " + name);
        }
    }

}