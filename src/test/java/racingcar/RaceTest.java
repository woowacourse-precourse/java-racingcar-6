package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceTest {
    public static List<String> players;
    private String userInput;

    @Test
    void separatePlayers() {
        Race race = new Race();
        race.separatePlayers("1, 2, 3");
        List<String> expectedResult = List.of("1","2","3");
        assertEquals(expectedResult, race.players);
    }

    @Test
    void initHashmap() {
    }

    @Test
    void printPlayers() {
    }

    @Test
    void updateStatus() {
    }
}