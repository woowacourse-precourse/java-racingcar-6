package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    @Test
    @DisplayName("자동차 이름 검증 정상동작")
    void car_names_good_case() {
        //given
        InputValidator inputValidator = new InputValidator();

        //when
        String goodCarNamesInput = "카,붕붕카,타요버스,시내버스,토마스버스,'";

        //then
        assertDoesNotThrow(() -> {
            inputValidator.validateCarNames(goodCarNamesInput);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"'붕붕카,타요버스,'", "'붕붕카,'", "',붕붕카'", "'붕붕카,,타요버스'"})
    @DisplayName("자동차 이름 검증 쉼표구분 예외")
    void car_names_쉼표구분_예외_테스트(String input) {
        //given
        InputValidator inputValidator = new InputValidator();

        //then
        assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름의 길이는 1이상 5이하여야 합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"'붕붕카,붕붕카를타는토마스'", "'붕붕카를타는토마스,타요버스'", "'붕붕카, "})
    @DisplayName("자동차 이름 검증 길이 예외")
    void car_names_길이_예외_테스트(String input) {
        //given
        InputValidator inputValidator = new InputValidator();

        //then
        assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름의 길이는 1이상 5이하여야 합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"'붕붕카,붕붕카'", "'타요버스, 타요버스'", "'타요버스 ,타요버스'", "'타요버스, 타요버스 '"})
    @DisplayName("자동차 이름 검증 중복 예외")
    void car_names_중복_예외_테스트(String input) {
        //given
        InputValidator inputValidator = new InputValidator();

        //then
        assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복되면 안됩니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"붕붕카", "타요버스"})
    @DisplayName("자동차 이름 검증 개수 예외")
    void car_names_개수_예외_테스트(String input) {
        //given
        InputValidator inputValidator = new InputValidator();

        //then
        assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 2개 이상 입력되어야 합니다");
    }
}