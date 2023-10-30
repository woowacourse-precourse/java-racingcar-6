package racingcar.domain.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundFactoryTest {
    RoundFactory roundFactory;

    @BeforeEach
    void setUp() {
        roundFactory = new RoundFactory();
    }

    @Test
    @DisplayName("정상입력시_round_객체_생성")
    void create_NormalInput_createRoundSuccess() {
        //given
        String normalInput = "3";

        //when
        Round actual = roundFactory.create(normalInput);

        //then
        Round expected = new Round(3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자가아닌_input_입력시_round_객체_실패")
    void create_NotNumberInput_createRoundFail() {
        //given
        String errorInput = "notNumber";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> roundFactory.create(errorInput));
    }

    @Test
    @DisplayName("overflow_입력시_round_객체_실패")
    void create_OverflowInput_createRoundFail() {
        //given
        String errorInput = "3000000000";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> roundFactory.create(errorInput));
    }

    @Test
    @DisplayName("음수_입력시_round_객체_실패")
    void create_NegativeInput_createRoundFail() {
        //given
        String errorInput = "-1";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> roundFactory.create(errorInput));
    }

}