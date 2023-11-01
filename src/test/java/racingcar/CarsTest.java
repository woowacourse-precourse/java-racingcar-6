package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni,"})
    public void 이름_개수_테스트(String carName) {
        assertThatThrownBy(() -> new Cars(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이상이어야 합니다.");
    }

    @Test
    public void 이름_중복_테스트() {
        assertThatThrownBy(() -> new Cars("pobi,pobi,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름입니다.");
    }
}
