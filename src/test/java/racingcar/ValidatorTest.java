package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Validator.CAR_NAME_COUNT_ERROR;
import static racingcar.Validator.CAR_NAME_DUPLICATE_ERROR;
import static racingcar.Validator.CAR_NAME_LENGTH_ERROR;
import static racingcar.Validator.ENDWITHS_IS_NOT_COMMA_ERROR;
import static racingcar.Validator.MAX_MOVING_NUMBER_ERROR;
import static racingcar.Validator.MIN_MOVING_NUMBER_ERROR;
import static racingcar.Validator.NOT_CONSIST_OF_ENGLISH_KOREAN_COMMA_ERROR;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private Validator validator = new Validator();

    @Test
    void validateInput_입력값이_영문자_한글_쉼표로_이루어져있는지() {
        String invalidInput = "한국,pobi,MYCAR,ahn, ";

        assertThatThrownBy(() -> validator.validateInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_CONSIST_OF_ENGLISH_KOREAN_COMMA_ERROR);
    }

    @Test
    void validateInput_입력값의_마지막이_쉼표인지() {
        String invalidInput = "한국,pobi,";

        assertThatThrownBy(() -> validator.validateInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ENDWITHS_IS_NOT_COMMA_ERROR);
    }

    @Test
    void validateCarNames_자동차이름이_1자부터_5자인지_확인1() {
        List<String> invalidList = Arrays.asList("pobi", "", "안종혁");

        assertThatThrownBy(() -> validator.validateCarNames(invalidList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_ERROR);
    }

    @Test
    void validateCarNames_자동차이름이_1자부터_5자인지_확인2() {
        List<String> invalidList = Arrays.asList("pobi", "안종혁", "mycars");

        assertThatThrownBy(() -> validator.validateCarNames(invalidList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_ERROR);
    }

    @Test
    void validateCarNames_자동차이름이_2개이상인지_확인1() {
        List<String> invalidList = Arrays.asList("pobi");

        assertThatThrownBy(() -> validator.validateCarNames(invalidList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_COUNT_ERROR);

    }

    @Test
    void validateCarNames_자동차이름이_2개이상인지_확인2() {
        List<String> validList = Arrays.asList("pobi", "종혁");

        assertThatCode(() -> validator.validateCarNames(validList))
                .doesNotThrowAnyException();
    }

    @Test
    void validateCarNames_자동차이름이_중복인지_확인1() {
        List<String> invalidList = Arrays.asList("pobi", "pobi", "종혁");

        assertThatThrownBy(() -> validator.validateCarNames(invalidList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATE_ERROR);
    }

    @Test
    void validateMovingNumber_자동차이동횟수가_숫자인지_확인() {
        String input = "1.1";

        assertThatThrownBy(() -> validator.validateMovingNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateMovingNumber_자동차이동횟수가_1이상인지_확인1() {
        String input = "-1";

        assertThatThrownBy(() -> validator.validateMovingNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MIN_MOVING_NUMBER_ERROR);
    }

    @Test
    void validateMovingNumber_자동차이동횟수가_1이상인지_확인2() {
        String input = "1";

        assertThatCode(() -> validator.validateMovingNumber(input))
                .doesNotThrowAnyException();
    }

    @Test
    void validateMovingNumber_자동차이동횟수가_최대20억인지_확인() {
        String input = "2000000001";

        assertThatThrownBy(() -> validator.validateMovingNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MAX_MOVING_NUMBER_ERROR);
    }
}
