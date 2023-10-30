package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("2개 미만의 이름을 입력하면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"test", ""})
    void validateCarNamesSizeTest(String inputName) {
        List<String> names = Arrays.asList(inputName);

        assertThatThrownBy(() -> inputValidator.validateCarNamesSize(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주에 참여할 자동차의 이름 수가 모자릅니다. 적어도 2개 이상의 이름을 입력해주세요.");
    }

    @DisplayName("5글자를 초과한 이름이면 예외처리")
    @Test
    void validateCarNameLengthTest() {
        List<String> names = Arrays.asList("test", "overNameTest1", "overNameTest2");

        assertThatThrownBy(() -> inputValidator.validateCarNameLength(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름이 5글자를 초과 했습니다. 5글자 이하의 이름으로 입력해주세요.");
    }
}