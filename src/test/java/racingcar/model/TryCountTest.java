package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TryCountTest {
    @Test
    void decrease_메서드는_시도회수를_1_감소시킨다() {
        TryCount count = new TryCount(2);
        count.decrease();
        assertThat(count.getCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, false", "1, true"})
    void isAbleTry_메서드는_시도할_수_있는지를_판별한다(Integer value, boolean result) {
        TryCount count = new TryCount(value);
        assertThat(count.isAbleTry()).isEqualTo(result);
    }
}
