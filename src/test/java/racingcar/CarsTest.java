package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.NumberValidator;
import racingcar.model.Participant;
import racingcar.model.Participants;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarsTest {

    @DisplayName("참가자 이름 가져오기 테스트")
    @ParameterizedTest
    @CsvSource({"1,pobi","2,woni","3,jun","4,debbie"})
    void getNameTest(int idx, String name) {
        Participant participant = new Participant(idx, name);
        Participants participants = new Participants();
        participants.addParticipant(participant);
        HashMap<Integer, Participant> participantMap = participants.getParticipants();
        assertTrue(participantMap.containsKey(idx));
        assertEquals(participantMap.get(idx), participant);
    }

    @DisplayName("참가자의 초기 위치 확인하기 테스트")
    @ParameterizedTest
    @CsvSource({"1,pobi"})
    void getInformationTest(int index, String name) {
        Participant participant = new Participant(index, name);
        assertThat(participant.getPoint()).isEqualTo(0);
    }

    @DisplayName("한 번 이동한 경우 테스트")
    @ParameterizedTest
    @CsvSource({"1,pobi,5"})
    void moveTest(int index, String name, int moveNumber) {
        Participant participant = new Participant(index, name);
        participant.go(moveNumber);
        assertThat(participant.getPoint()).isEqualTo(1);
    }
}

