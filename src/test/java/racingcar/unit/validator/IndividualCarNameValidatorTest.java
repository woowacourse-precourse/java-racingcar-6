package racingcar.unit.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tdd.config.ErrorMessage.SPLIT_CAR_LENGTH_ERROR_MESSAGE;
import static tdd.config.ErrorMessage.SPLIT_CAR_UNIQUE_ERROR_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;
import tdd.validator.IndividualCarNameValidator;
import tdd.validator.Validator;

public class IndividualCarNameValidatorTest {
    Validator<List<String>> carNameValidator = new IndividualCarNameValidator();
    String regexErrorMessage = "자동차 이름은 영어 소문자, 숫자만 입력 가능합니다. 잘못 입력한 자동차 이름 : ";
    String carLengthErrorMessage = SPLIT_CAR_LENGTH_ERROR_MESSAGE.getMessage();
    String notUniqueErrorMessage = SPLIT_CAR_UNIQUE_ERROR_MESSAGE.getMessage();

    private void assertThrowExceptionTest(String errorMessage, String ...args) {
        List<String> splitCarName = new ArrayList<>(Arrays.asList(args));
        assertThatThrownBy(() -> carNameValidator.validate(splitCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    private void assertNotThrowExceptionTest(String ...args) {
        List<String> splitCarName = new ArrayList<>(Arrays.asList(args));
        assertThatCode(() -> carNameValidator.validate(splitCarName))
                .doesNotThrowAnyException();
    }
    @Test
    void 이름이_1글자_이상_5글자_이하면_예외처리_발생_안해서_통과() {
        assertNotThrowExceptionTest("a2c");
    }

    @Test
    void 이름이_없으면_예외처리_발생해서_통과() {
        assertThrowExceptionTest(carLengthErrorMessage, "");
    }

    @Test
    void 이름이_6글자_이상이면_예외처리_발생해서_통과() {
        assertThrowExceptionTest(carLengthErrorMessage, "abs134");
    }

    @Test
    void 이름에_공백_있으면_예외처리_발생해서_통과() {
        assertThrowExceptionTest(regexErrorMessage, "1a ");
    }

    @Test
    void 이름에_대문자_있으면_예외처리_발생해서_통과() {
        assertThrowExceptionTest(regexErrorMessage, "1Aa");
    }

    @Test
    void 이름에_특수문자_있으면_예외처리_발생해서_통과() {
        assertThrowExceptionTest(regexErrorMessage, "@,b1");
    }

    @Test
    void 검증시_틀린_입력_출력시_통과() {
        String message = "자동차 이름은 영어 소문자, 숫자만 입력 가능합니다. 잘못 입력한 자동차 이름 : a1br김, Ab1";
        assertThrowExceptionTest(message, "ab134", "a1br김", "Ab1");
    }

    @Test
    void 중복_이름_있으면_예외처리_발생해서_통과() {
        assertThrowExceptionTest(notUniqueErrorMessage, "ab1", "a1b", "ab1", "abb", "a1b");
    }

    @Test
    void 자동차_이름에_쉼표_있으면_예외처리_발생해서_통과() {
        assertThrowExceptionTest(regexErrorMessage, ",,,,,,1,");
    }
}
