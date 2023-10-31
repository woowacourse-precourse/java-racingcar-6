package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    public void 시도횟수_검증_테스트() {
        //given
        int minusValue = -1;
        int maxValue = Integer.MAX_VALUE;

        //when
        //then
        Assertions.assertThatThrownBy(() -> {
            new TryCount(minusValue);
        }).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> {
            new TryCount(maxValue);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
