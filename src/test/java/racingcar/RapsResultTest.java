package racingcar;

import org.junit.jupiter.api.Test;
import pojo.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RapsResultTest {
    private RacingCar racingCar = new RacingCar("테스터", 3);
    private RapsResult rapsResult = new RapsResult(racingCar);

    @Test
    void testReader_숫자가_4이상이면_True_반환() {

        int num = 4;
        boolean result = rapsResult.reader(4);

        assertTrue(result);
    }


    @Test
    void testChangeCarStatus_참일경우_자동차_전진() {

        boolean flag = true;

        rapsResult.changeCarStatus(flag);
        int distanceNum = racingCar.getDistance();

        assertThat(distanceNum).isEqualTo(4);
    }

    @Test
    void testResultText_1경기_끝난후_자동차_결과_텍스트_생성() {

        String result = rapsResult.resultText();

        assertThat(result).isEqualTo("테스터 : ---");
    }

    @Test
    void testDistanceText_1경기_끝난후_자동차_이동거리_텍스트_반환() {

        String result = rapsResult.distanceText();

        assertThat(result).isEqualTo("---");
    }

    @Test
    void testGenerateNumber_랜덤_숫자_생성_반환() {

        int result = rapsResult.generateNumber();

        assertTrue(result >= 0 && result <= 9);
    }

    @Test
    void testRaceResult_자동차_1경기_결과_출력() {

        String result = rapsResult.raceResult();

        assertEquals("테스터 : ----", result);
    }
}