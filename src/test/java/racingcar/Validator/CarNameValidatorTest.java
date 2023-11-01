package racingcar.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Validator.CarNameValidator;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {


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
