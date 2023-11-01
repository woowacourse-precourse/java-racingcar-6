package racingcar.unitTest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.vo.CarName;

public class CarNameTest {

    @Test
    @DisplayName("예외를 발생시킨다_차 이름이 5글자를 초과할 경우")
    void CarName_lessThan5() {
        assertThatThrownBy(() -> new CarName("sangci"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이내여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("예외를 발생시킨다_차 이름이 빈 값일 경우")
    void CarName_isBlank(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 빈 값이 들어올 수 없습니다.");
    }

    @Test
    @DisplayName("통과한다_불변성을 가질 경우")
    void CarName_isImmutable() {
        CarName name1 = new CarName("park");
        CarName name2 = new CarName("park");

        assertThat(name1).isEqualTo(name2);
    }
}
