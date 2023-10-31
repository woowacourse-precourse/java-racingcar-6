package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("입력 받는 것이 숫자이다.")
    void isNumber() {
        //given
        String number = "1";

        //when
        Boolean result = Validator.isNotNumber(number);

        //then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("입력 받는 것이 숫자가 아니다.")
    void isNotNumber() {
        //given
        String str = "a";

        //when
        Boolean result = Validator.isNotNumber(str);

        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("해당 문자열이 5자 이내이다.")
    void isCarName() {
        //given
        String carName = "pobi";

        //when
        Boolean result = Validator.isNotCarName(carName);

        //then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("해당 문자열이 6자 이상이다.")
    void isNotCarName() {
        //given
        String carName = "iamcar";

        //when
        Boolean result = Validator.isNotCarName(carName);

        //then
        Assertions.assertThat(result).isTrue();
    }
}