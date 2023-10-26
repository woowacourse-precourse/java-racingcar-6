package racingcar.io.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.exception.ExceptionMessage.InputException.CAR_HAS_INVALID_CHARACTER;

public class CarInputValidatorTest {
    private final CarInputValidator sut = new CarInputValidator();

    @ParameterizedTest
    @ValueSource(strings = {" abc", ":abc", "?abc", "abc&"})
    @DisplayName("각 자동차에 유효하지 않은 문자(공백, 특수문자, ...)가 존재하면 예외가 발생한다")
    void throwExceptionByInputHasSpace(final String userInput) {
        assertThatThrownBy(() -> sut.validate(List.of(userInput)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_HAS_INVALID_CHARACTER.message);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "abc12"})
    @DisplayName("경주에 참여하는 자동차 목록 검증에 성공한다")
    void success(final String userInput) {
        assertDoesNotThrow(() -> sut.validate(List.of(userInput)));
    }
}
