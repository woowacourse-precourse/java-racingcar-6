package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RangedRandomNumberPickerTest {


    @Test
    void 범위_내의_숫자를_뽑을_수_있다() {
        int rangeStart = 0;
        int rangeEnd = 100;
        RangedRandomNumberPicker rangedRandomNumberPicker
            = new RangedRandomNumberPicker(rangeStart, rangeEnd);

        assertThat(rangedRandomNumberPicker.pickNumber()).isGreaterThanOrEqualTo(rangeStart);
        assertThat(rangedRandomNumberPicker.pickNumber()).isLessThanOrEqualTo(rangeEnd);
    }
}
