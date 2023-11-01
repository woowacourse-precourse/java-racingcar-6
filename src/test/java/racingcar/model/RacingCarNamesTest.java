package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingCarNamesTest {

    @Test
    @DisplayName("자동차 이름이 중독되면 예외가 발생한다.")
    void should_ThrowException_When_CarNamesDuplicate() {
        List<String> carNames = List.of("car1", "car1", "car3");

        Assertions.assertThatThrownBy(() -> new RacingCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
