package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    public void 자동차이름_빈값() {
        assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력해 주세요.");
    }

    @Test
    public void 자동차이름_널() {
        assertThatThrownBy(() -> new Cars(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력해 주세요.");
    }

    @Test
    public void 자동차이름_쉼표로끝남() {
        assertThatThrownBy(() -> new Cars("a,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표");
        assertThatThrownBy(() -> new Cars(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표");
        assertThatThrownBy(() -> new Cars("a,b,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표");
    }
}
