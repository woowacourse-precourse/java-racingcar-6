package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.CarNames;

public class CarNamesTest {
    @Test
    void 이름에_대한_예외_처리() {
        // 예외를 던지는 코드를 실행하고 예외가 발생하는지 확인
        assertThatThrownBy(() -> {
            CarNames carNames = new CarNames("pobi,o");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
