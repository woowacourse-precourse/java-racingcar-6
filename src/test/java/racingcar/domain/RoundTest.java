package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoundTest {
    private static final int TOTAL_ROUND = 5;
    Round round;

    @BeforeEach
    void beforeEach(){
        round = new Round(TOTAL_ROUND);
    }

    @Test
    void 마지막_라운드_전(){
        // when
        round.next();

        // then
        Assertions.assertThat(round.isEnd()).isEqualTo(false);
    }


}