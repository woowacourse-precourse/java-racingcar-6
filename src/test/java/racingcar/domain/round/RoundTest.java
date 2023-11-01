package racingcar.domain.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RoundTest {

    private static final int ROUND_INPUT = 5;
    Round round;

    @BeforeEach
    void setUp() {
        round = new Round(ROUND_INPUT);
    }

    @Test
    @DisplayName("round_input_만큼_isLeft_호출")
    void isLeft_isLeftCalledSameAsInputCount() {
        //given
        int actual = 0;

        //when
        while (round.isLeft()) {
            actual++;
        }

        //then
        assertThat(actual).isEqualTo(ROUND_INPUT);
    }

}