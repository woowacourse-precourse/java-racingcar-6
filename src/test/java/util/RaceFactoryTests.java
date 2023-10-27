package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.participant.Participant;
import racingcar.domain.participant.ParticipantFactory;
import racingcar.domain.participant.ParticipantFactoryImpl;
import racingcar.domain.race.Race;
import racingcar.domain.race.RaceFactory;
import racingcar.domain.race.RaceFactoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceFactoryTests {
    private final RaceFactory raceFactory = new RaceFactoryImpl();
    private final ParticipantFactory participantFactory = new ParticipantFactoryImpl();

    @Test
    @DisplayName("경주 생성기로 생성한 경주 객체가 동일한 참가자 목록을 가지고 있어야 한다")
    void test1() {
        // given
        String[] carNames = {"visnu", "shiva", "kali", "brahma"};
        List<Participant> participants = new ArrayList<>();

        for ( String carName : carNames ) {
            participants.add( participantFactory.getParticipant(carName) );
        }

        // then
        Race race = raceFactory.getRace(participants, 5);

        // when
        assertEquals(participants, race.getParticipants());
    }
}
