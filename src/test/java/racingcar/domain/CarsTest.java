package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("자동차 이름 중복일 때 예외 발생")
    @Test
    void 자동차_이름_중복_예외_발생() {
        assertThatThrownBy(() -> new Cars(List.of("aaa", "bbb", "aaa")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }
}
