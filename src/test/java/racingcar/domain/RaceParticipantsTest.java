package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.generator.NumberGenerator;
import racingcar.domain.generator.RandomNumberGenerator;

@DisplayName("RaceParticipants 클래스")
class RaceParticipantsTest {
    @Test
    @DisplayName("RaceParticipants 생성")
    void testCreateRaceParticipants() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        RaceParticipants raceParticipants = new RaceParticipants("pobi,crong,honux", numberGenerator);
        assertEquals(3, raceParticipants.getRacingCarList().size());
        assertAll(
                () -> assertEquals("pobi", raceParticipants.getRacingCarList().get(0).getName()),
                () -> assertEquals("crong", raceParticipants.getRacingCarList().get(1).getName()),
                () -> assertEquals("honux", raceParticipants.getRacingCarList().get(2).getName())
        );
    }

    @Nested
    @DisplayName("자동차 이름에 대한 예외 처리")
    class RaceParticipantsNameExceptionTest {
        @Test
        @DisplayName("자동차 이름이 비어 있을 경우 예외 발생")
        void raceParticipantsNameEmpty() {
            NumberGenerator numberGenerator = new RandomNumberGenerator();
            assertThrows(IllegalArgumentException.class, () -> new RaceParticipants("", numberGenerator));
        }

        @Test
        @DisplayName("자동차 이름이 중복된 경우 에러 처리")
        void raceParticipantsNameDuplicate() {
            NumberGenerator numberGenerator = new RandomNumberGenerator();
            assertThrows(IllegalArgumentException.class,
                    () -> new RaceParticipants("pobi,pobi,alstn", numberGenerator));
        }
    }
}
