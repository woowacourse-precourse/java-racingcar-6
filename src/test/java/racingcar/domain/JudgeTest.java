package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    @Test
    void 숫자4이상인가(){
        boolean isOk = Judge.judge4OrMore(5);

        assertEquals(isOk, true);
    }

}