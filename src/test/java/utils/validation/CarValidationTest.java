package utils.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.TransformUtil;
import utils.message.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarValidationTest {
    @ParameterizedTest
    @DisplayName("자동차 이름 사이즈가 5가 넘어거나 1일때 예외")
    @ValueSource(strings = {"a", "aaaaaa"})
    public void 자동차이름_사이즈가_5가넘거나_1일때(String carName) {
        // when
        Throwable exception = Assertions.catchThrowable(() -> CarValidation.carName(TransformUtil.commasToList(carName)));

        // then
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_SIZE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름에 숫자 혹은 특수문자가 들어갈때")
    @ValueSource(strings = {"a1", "111", "!@#$"})
    public void 자동차_이름에_숫자_혹은_특수문자가_들어갈때(String carName) {
        // when
        Throwable exception = Assertions.catchThrowable(() -> CarValidation.carName(TransformUtil.commasToList(carName)));

        // then
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_PATTERN.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 중복이 포함되어있을때")
    public void 자동차_이름에_중복이_포함되어있을때() {
        // given
        List<String> carNames = List.of("car", "car");

        // when
        Throwable exception = Assertions.catchThrowable(() -> CarValidation.carName(carNames));

        // then
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_UNIQUE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("정상적인 자동차 이름")
    @ValueSource(strings = {"aa", "bbb", "cccc", "ddddd", "하나", "김영수"})
    public void 자동차이름(String carName) {
        // then
        assertDoesNotThrow(() -> CarValidation.carName(TransformUtil.commasToList(carName)));
    }

}
