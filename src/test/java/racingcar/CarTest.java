package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_생성_5자초과_에러처리_테스트() {
        assertThatThrownBy(() -> new Car("송민준입니다")).isInstanceOf(IllegalArgumentException.class);
    }
}
