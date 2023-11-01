package study;

import org.junit.jupiter.api.Test;
import racingcar.Application;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundResultTest {

    @Test
    void testRoundResult() {
        Application carRace = new Application();
        carRace.carNamesList.add("Car1");
        carRace.carNamesList.add("Car2");
        carRace.scoreList.add(0);
        carRace.scoreList.add(0);

        // 테스트를 위해 randomNumbers 리스트에 값을 추가
        carRace.randomNumbers.add(4);
        carRace.randomNumbers.add(5);

        carRace.roundResult();

        // After the round, both cars should have their scores increased by 1
        assertEquals(1, carRace.scoreList.get(0));
        assertEquals(1, carRace.scoreList.get(1));
    }
}


