package racingcar.domain.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundFactoryTest {
    RoundFactory roundFactory;

    private static final String NORMAL_ROUND_STRING = "5";
    private static final int CONVERTED_ROUND_NUMBER = 5;
    private static final String NOT_NUMBER_ROUND_STRING = "notNumber";
    private static final String OVERFLOW_ROUND_STRING = "3000000000";
    private static final String NEGATIVE_ROUND_STRING = "-1";

    @BeforeEach
    void setUp() {
        roundFactory = new RoundFactory();
    }

    @Test
    @DisplayName("정상입력시_round_객체_생성")
    void create_NormalInput_createRoundSuccess() {
        //given
        Round expected = new Round(CONVERTED_ROUND_NUMBER);

        //when
        Round actual = roundFactory.create(NORMAL_ROUND_STRING);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자가아닌_input_입력시_round_객체_실패")
    void create_NotNumberInput_createRoundFail() {
        //when & then
        assertThrows(IllegalArgumentException.class, () -> roundFactory.create(NOT_NUMBER_ROUND_STRING));
    }

    @Test
    @DisplayName("overflow_입력시_round_객체_실패")
    void create_OverflowInput_createRoundFail() {
        //when & then
        assertThrows(IllegalArgumentException.class, () -> roundFactory.create(OVERFLOW_ROUND_STRING));
    }

    @Test
    @DisplayName("음수_입력시_round_객체_실패")
    void create_NegativeInput_createRoundFail() {
        //when & then
        assertThrows(IllegalArgumentException.class, () -> roundFactory.create(NEGATIVE_ROUND_STRING));
    }

}