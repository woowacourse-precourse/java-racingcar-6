package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaceTest {
    @Test
    void separatePlayers() {
        Race race = new Race();
        race.separatePlayers("1, 2, 3");
        List<String> expectedResult = List.of("1","2","3");
        assertEquals(expectedResult, race.players);
    }

    @Test
    void findWinner() {
        Race race = new Race();
        race.playingStatus.put("1",1);
        race.playingStatus.put("2",5);
        race.findWinner();
        List<String> expectedResult = List.of("2");
        assertEquals(expectedResult, race.winners);
    }



}