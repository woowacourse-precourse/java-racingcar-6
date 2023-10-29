package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationTest {

    @ParameterizedTest
    @DisplayName("입력값에서 처음이나 끝이 쉼표(,) 혹은 쉼표들이 연속되면 예외 발생")
    @ValueSource(strings = {
            ",name1,name2", "name1,name2,", "name1,,name2",
            ",,name1,name2", "name1,name2,,", "name1,,,name2",
    })
    void checkNullOrSpaceInNameInput_commaTest(String input) {
        Validation sample = new Validation();
        assertThatIllegalArgumentException().isThrownBy(() -> sample.checkNullOrSpaceInNameInput(input));
    }

    @ParameterizedTest
    @DisplayName("입력값에서 자동차 이름의 첫글자나 마지막 글자가 공백문자, 혹은 연속된 공백문자가 사용되면 예외 발생")
    @ValueSource(strings = {
            "name1, ,name3", "name1,  ,name3", "name1,name2 ,name3",
            "name1, name2,name3", "name1, name2 ,name3", "a   b,name2,name3",
            "abc  ,name2,name3"
    })
    void checkNullOrSpaceInNameInput_space_exceptionTest(String input) {
        Validation sample = new Validation();
        assertThatIllegalArgumentException().isThrownBy(() -> sample.checkNullOrSpaceInNameInput(input));
    }

    @ParameterizedTest
    @DisplayName("입력값에 포함된 자동차 이름의 중간에만 공백문자가 사용되는 경우에는 정상 종료")
    @ValueSource(strings = {"name1,A B,name2", "A B C,name2,name3"})
    void checkNullOrSpaceInNameInput_space_normalTest(String input) {
        Validation sample = new Validation();
        assertThatCode(() -> sample.checkNullOrSpaceInNameInput(input)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("파싱된 문자열의 한 이름 토큰의 길이가 5를 초과하면 예외 발생, 길이가 5 이하면 정상 종료")
    void checkNameTokenLengthOver_test() {
        Validation sample = new Validation();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> sample.checkNameTokenLengthOver("sample"));
        assertThatCode(() -> sample.checkNameTokenLengthOver("name")).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("현재 이름 토큰이 이미 Map에 저장된 key이면 예외 발생")
    @ValueSource(strings = {"name1", "name2", "name3"})
    void checkNameTokenDuplicated_exceptionTest(String inputToken) {
        Validation sample = new Validation();
        Map<String, Integer> inputMap = Map.of("name1", 0, "name2", 0, "name3", 0);
        assertThatIllegalArgumentException().isThrownBy(() -> sample.checkNameTokenDuplicated(inputToken, inputMap));
    }

    @Test
    @DisplayName("현재 이름 토큰이 Map에 없는 새로운 key이면 정상 종료")
    void checkNameTokenDuplicated_normalTest() {
        Validation sample = new Validation();
        Map<String, Integer> inputMap = Map.of("name1", 0, "name2", 0, "name3", 0);
        String inputToken = "name4";
        assertThatCode(() -> sample.checkNameTokenDuplicated(inputToken, inputMap)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("문자열로 입력된 시도횟수를 정수로 변환할 수 없으면 예외 처리")
    @ValueSource(strings = {"5.0", "12a3", " 5 "})
    void checkRoundsNumeric_exceptionTest(String input) {
        Validation sample = new Validation();
        assertThatIllegalArgumentException().isThrownBy(() -> sample.checkRoundsNumeric(input));
    }

    @ParameterizedTest
    @DisplayName("문자열로 입력된 시도횟수를 정수로 변환할 수 있으면 정상 종료")
    @ValueSource(strings = {"15", "0", "-123"})
    void checkRoundsNumeric_normalTest(String input) {
        Validation sample = new Validation();
        assertThatCode(() -> sample.checkRoundsNumeric(input)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("정수로 변환한 시도횟수가 0이거나 음수면 예외 처리, 양수면 정상 종료")
    void checkRoundsZeroOrNegative_test() {
        Validation sample = new Validation();
        assertThatIllegalArgumentException().isThrownBy(() -> sample.checkRoundsZeroOrNegative(-123));
        assertThatIllegalArgumentException().isThrownBy(() -> sample.checkRoundsZeroOrNegative(0));
        assertThatCode(() -> sample.checkRoundsZeroOrNegative(5)).doesNotThrowAnyException();
    }
}
