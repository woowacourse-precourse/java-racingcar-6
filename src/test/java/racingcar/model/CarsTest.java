package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 자동차들_생성시_이름이_중복되면_예외가_발생한다() {
        List<String> names = List.of("pobi", "pobi");

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }
}
