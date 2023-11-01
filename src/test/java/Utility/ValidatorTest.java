package Utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Validator.CarNameValidator;
import Validator.GameRoundValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Nested
    @DisplayName("자동차 이름은 5자 이하만 가능합니다.")
    class CarNameValidatorTest {

        @Test
        void 자동차_이름이_공백_일때_오류() {

            //given
            String input = "";

            assertThatThrownBy(() -> CarNameValidator.getInstance().validateCarName(input)) //when
                    .isInstanceOf(IllegalArgumentException.class); //then

        }

        @Test
        void 자동차_이름이_5자_초과_일때_오류() {

            //given
            String input = "longName";

            assertThatThrownBy(() -> CarNameValidator.getInstance().validateCarName(input)) //when
                    .isInstanceOf(IllegalArgumentException.class); //then
        }
    }

    @Nested
    @DisplayName("게임의 횟수는 0이상이며 자료형의 범위를 초과해서는 안됩니다.")
    class GameRoundValidateTest {

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


}