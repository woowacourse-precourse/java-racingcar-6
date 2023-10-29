package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarNameTest {

    @ParameterizedTest(name = "[테스트 케이스 {index}] 자동차 이름 = {arguments} ")
    @ValueSource(strings = {"banana", ""})
    @DisplayName("자동차 이름이 다섯글자를 초과하거나 공백이면 예외가 발생한다.")
    public void should_ThrowException_When_CarNameAboveFiveOrIsEmpty(String carName) {
        assertThatThrownBy(() -> new RacingCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
