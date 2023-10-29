package racingcar.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundModelTest {

    private final RoundModel roundModel = new RoundModel();
    @Test
    @DisplayName("시도 횟수에 대한 전처리 확인")
    void preProcessing() {
        //given
        String round = "5";
        Integer expected = 5;

        //when
        Integer result = roundModel.preProcessing(round);

        //then
        assertEquals(expected, result);
    }
}