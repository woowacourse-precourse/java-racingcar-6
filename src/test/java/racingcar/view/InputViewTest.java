package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

class InputViewTest {

    @DisplayName("입력가능한 자동차 이름 테스트")
    @Test
    void inputCarNames() {
        // given
        String input = "슈퍼 카,go123,W o W";

        // when
        CarNameValidator.validate(input);

        // then (예외가 발생하지 않는다.)
    }

    @DisplayName("입력가능한 재시도 횟수 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "101", "2000"})
    void inputTryCount(String input) {
        // when
        TryCountValidator.validate(input);

        // then (예외가 발생하지 않는다.)
    }
}