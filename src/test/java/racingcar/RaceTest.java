package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceTest {

    @Test
    void findFinalWinner_메서드로_raceAccumulations가_가장_큰_car가_출력되어야_한다() {
        Race race = Race.initializeRaceInformation("1,2,3", 0, Arrays.asList(10, 2, 3));
        List<String> finalWinners = race.findFinalWinner();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("1");

        assertEquals(expectedList, finalWinners);
    }

    @Test
    void 가장_큰_car가_여러_개라면_여러_개_전부_출력되어야_한다() {
        Race race = Race.initializeRaceInformation("1,2,3", 0, Arrays.asList(10, 10, 3));
        List<String> finalWinners = race.findFinalWinner();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("1");
        expectedList.add("2");

        assertEquals(expectedList, finalWinners);
    }
}