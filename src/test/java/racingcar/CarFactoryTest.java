package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarFactoryTest {
    private final CarFactory carFactory = new CarFactory();

    @Test
    void 이름_목록으로부터_자동차_생성() {
        assertThat(carFactory.generate(List.of("pobi", "woni")))
                .containsExactly(new Car("pobi"), new Car("woni"));
    }

    @ParameterizedTest(name = "이름이 {0}인 경우 예외")
    @ValueSource(strings = {"javaji", ""})
    void 이름이_5글자_초과인_경우_예외(String invalidName) {
        assertThatThrownBy(
                () -> carFactory.generate(List.of(invalidName)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하, 1자 이상만 가능합니다.");
    }

    @Test
    void 이름이_중복된_경우_예외() {
        assertThatThrownBy(
                () -> carFactory.generate(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }
}
