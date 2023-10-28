package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    Car car;

    @Test
    void splitNames_메서드로_주어진_값을_구분() {
        String input = "pobi,woni,jun";
        car = new Car(input);

        assertThat(car.getCarNames()).contains("woni", "jun", "pobi");
        assertThat(car.getCarNames()).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void splitNames_메서드로_구분된_각각의_이름_길이가_5초과시_에러() {
        String input = "pobi,woni,junnnnn";

        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하로만 가능합니다.");
    }
}
