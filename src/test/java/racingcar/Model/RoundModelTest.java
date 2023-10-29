package racingcar.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoundModelTest {

    private final RoundModel roundModel = new RoundModel();
    @Test
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