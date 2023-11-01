package racingcar.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Validator.GameRoundValidator;
import org.junit.jupiter.api.Test;

public class GameRoundValidatorTest {

    @Test
    void int_max_보다_크면_오류() {
        //given
        String gameRound = "2147483648";

        assertThatThrownBy(() -> GameRoundValidator.getInstance().validateGameRoundAndReturn(gameRound)) //when
                .isInstanceOf(IllegalArgumentException.class); //then

    }

    @Test
    void 숫자_0보다_작으면_오류() {
        //given
        String gameRound = "-1";
        assertThatThrownBy(() -> GameRoundValidator.getInstance().validateGameRoundAndReturn(gameRound)) //when
                .isInstanceOf(IllegalArgumentException.class); //then
    }


}
