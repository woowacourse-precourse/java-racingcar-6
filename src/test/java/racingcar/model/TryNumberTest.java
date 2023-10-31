package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TryNumberTest {

    @Test
    @DisplayName("시도 횟수 생성")
    void of() {
        TryNumber tryNumber = TryNumber.of(5);

        assertThat(tryNumber).isEqualTo(TryNumber.of(5));
    }
}