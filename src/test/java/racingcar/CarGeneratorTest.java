package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarGeneratorTest {
    private final CarGenerator carGenerator = new CarGenerator();

    @Test
    void 이름_목록으로부터_자동차_생성() {
        assertThat(carGenerator.generate(List.of("pobi", "woni")))
                .containsExactly(new Car("pobi"), new Car("woni"));
    }
}
