package racingcar.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_생성_실패_null_입력() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 자동차_생성_실패_길이가_5글자보다_큰_입력() {
        assertThatThrownBy(() -> new Car("aaaaaa"))
               .isInstanceOf(IllegalArgumentException.class);
    }
}
