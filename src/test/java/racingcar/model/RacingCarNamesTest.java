package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarNamesTest {

    @Test
    @DisplayName("자동차 이름이 중독되면 예외가 발생한다.")
    void should_ThrowException_When_CarNamesDuplicate() {
        List<String> carNames = List.of("park", "park", "yong");

        Assertions.assertThatThrownBy(() -> new RacingCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
