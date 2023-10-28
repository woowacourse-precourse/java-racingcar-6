package racingcar.domain.trial;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.game.validate.IntegerTrialValidator;

class TrialTest {

    @DisplayName("시도횟수를 정수로 입력하지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"12.3", "abc"})
    @ParameterizedTest
    void getNoneIntegerTrial(String number) {
        Assertions.assertThatThrownBy(() -> IntegerTrialValidator.validate(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
