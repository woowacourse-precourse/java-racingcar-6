package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("입력값 전처리 테스트 - Null 데이터 - 오류")
    void preprocessNullInputTest() {
        assertThatThrownBy(() -> inputValidator.preprocessInputString(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값 전처리 테스트 - 빈 문자열 데이터 - 오류")
    void preprocessEmptyInputTest() {
        assertThatThrownBy(() -> inputValidator.preprocessInputString(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값 전처리 테스트 - 공백 포함 데이터 - 성공")
    @ValueSource(strings = {"po bi"})
    @ParameterizedTest
    void preprocessSpacingInputTest(String names) {
        assertThat(inputValidator.preprocessInputString(names)).isEqualTo("pobi");
    }

    @DisplayName("입력값 전처리 테스트 - 공백/빈 문자열 포함 데이터 - 성공")
    @ValueSource(strings = {"po bi, "})
    @ParameterizedTest
    void preprocessSpacingWIthEmptyInputTest(String names) {
        assertThat(inputValidator.preprocessInputString(names)).isEqualTo("pobi,");
    }

    @DisplayName("자동차 이름 유효성 테스트 - 정상 데이터 - 성공")
    @ValueSource(strings = {"pobi,inss,yh"})
    @ParameterizedTest
    void validateCorrectInputTest(String names) {
        List<String> resultNames = Arrays.asList("pobi", "inss", "yh");
        assertThat(inputValidator.validateCarsNameInput(names)).isEqualTo(resultNames);
    }

    @DisplayName("자동차 이름 유효성 테스트 - 구분자 없는 데이터 - 오류")
    @ValueSource(strings = {"pobiinssyh"})
    @ParameterizedTest
    void validateInputWithoutSeparatorTest(String names) {
        assertThatThrownBy(() -> inputValidator.validateCarsNameInput(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 1~5자로, 구분자는 쉼표(,)를 사용해주세요.");
    }

    @DisplayName("자동차 이름 유효성 테스트 - 5자 초과 데이터 - 오류")
    @ValueSource(strings = {"pobi,inssyh"})
    @ParameterizedTest
    void validateInputWrongRangeTest(String names) {
        assertThatThrownBy(() -> inputValidator.validateCarsNameInput(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 1~5자로 입력해주세요.");
    }

    @DisplayName("자동차 이름 유효성 테스트 - 중복되는 데이터 - 오류")
    @ValueSource(strings = {"pobi,pobi"})
    @ParameterizedTest
    void validateInputDuplicatedTest(String names) {
        assertThatThrownBy(() -> inputValidator.validateCarsNameInput(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복되는 이름은 입력할 수 없습니다.");
    }
}
