package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.exception.DuplicatedCarException;
import racingcar.exception.NonNullCarNameException;
import racingcar.exception.UnderCarMinNumException;
import racingcar.exception.UnderCarNameLengthException;

class RaceParticipantsTest {
    @Test
    public void testValidRaceParticipants() {
        List<String> names = Arrays.asList("car1", "car2", "car3");
        RaceParticipants raceParticipants = new RaceParticipants(names);

        assertEquals(3, raceParticipants.getParticipantCars().size());
    }

    @Test
    public void testUnderMinCarNumException() {
        List<String> names = Arrays.asList("car1");
        assertThrows(UnderCarMinNumException.class, () -> new RaceParticipants(names));
    }

    @Test
    public void testDuplicatedCarException() {
        List<String> names = Arrays.asList("car1", "car1");
        assertThrows(DuplicatedCarException.class, () -> new RaceParticipants(names));
    }

    @Test
    public void testUnderCarNameLengthException() {
        List<String> names = Arrays.asList("car123456", "car2");
        assertThrows(UnderCarNameLengthException.class, () -> new RaceParticipants(names));
    }

    @Test
    public void testNonNullCarNameException() {
        List<String> names = Arrays.asList("", "car2");
        assertThrows(NonNullCarNameException.class, () -> new RaceParticipants(names));
    }

}