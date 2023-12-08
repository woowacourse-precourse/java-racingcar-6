package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.type.PlayType.MAX_NUM;
import static racingcar.type.PlayType.MIN_NUM;

public class PickRandomNumberTest {
    @DisplayName("올바른 범위의 랜덤한 숫자 생성 테스트")
    @Test
    void checkPickRandomNumber() {
        assertThat(PickRandomNumber.generate()).isBetween(MIN_NUM.getPlayValue(), MAX_NUM.getPlayValue());
    }
}
