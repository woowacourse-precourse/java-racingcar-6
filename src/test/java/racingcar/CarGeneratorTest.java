package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarGeneratorTest {
    private final CarGenerator carGenerator = new CarGenerator();

    @Test
    void 이름_목록으로부터_자동차_생성() {
        assertThat(carGenerator.generate(List.of("pobi", "woni")))
                .containsExactly(new Car("pobi"), new Car("woni"));
    }

    @Test
    void 이름이_5글자_초과인_경우_예외() {
        assertThatThrownBy(
                () -> carGenerator.generate(List.of("ppppobi", "woni")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }
}
