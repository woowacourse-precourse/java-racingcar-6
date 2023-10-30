package racingcar.domain.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RoundTest {

    private static final int INPUT = 5;
    Round round;

    @BeforeEach
    void setUp() {
        round = new Round(INPUT);
    }

    @Test
    @DisplayName("overflow_입력시_round_객체_실패")
    void isLeft_isLeftCalledSameAsInputCount() {
        //given
        int actual = 0;
        int expected = INPUT;

        //when
        while (round.isLeft()) {
            actual++;
        }

        //then
        assertThat(actual).isEqualTo(expected);
    }

}