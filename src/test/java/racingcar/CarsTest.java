package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class CarsTest {

    @Test
    @DisplayName("이름 중복시 예외를 던진다.")
    void existSameName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(new String[]{"coco", "ham", "ham"}));
    }
}