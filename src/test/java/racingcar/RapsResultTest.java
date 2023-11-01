package racingcar;

import org.junit.jupiter.api.Test;
import pojo.RacingCar;

import static org.junit.jupiter.api.Assertions.*;

class RapsResultTest {
    RapsResult rapsResult = new RapsResult(new RacingCar("테스터",0));
    @Test
    void testReader_숫자가_4이상_이면_True_출력() {

        int num = 4;
        boolean result = rapsResult.reader(4);

        assertTrue(result);
    }


    @Test
    void changeCarStatus() {
    }

    @Test
    void resultText() {
    }

    @Test
    void distanceText() {
    }

    @Test
    void determineForward() {
    }

    @Test
    void forwardOrNot() {
    }
}