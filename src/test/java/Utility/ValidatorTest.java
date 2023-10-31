package Utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Validator.CarNameValidator;
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


}