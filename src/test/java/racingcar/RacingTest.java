package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingTest {

    private Racing racing;
    private int round;

    @BeforeEach
    void setUp() {
        String[] racerNameArray = {"pobi", "MJ", "tjwls"};
        round = 3;
        racing = new Racing(racerNameArray, round);
    }

    @Test
    void testCarRacingGameStart() {
        racing.carRacingGameStart();
    }
}




