package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    Car car;
    String input;

    @BeforeEach
    void setUp() {
        input = "pobi,woni,jun";
        car = new Car(input);
    }

    @Test
    void splitNames_메서드로_주어진_값을_구분() {
        assertThat(car.getCars()).containsKey("pobi");
        assertThat(car.getCars()).containsKey("woni");
        assertThat(car.getCars()).containsKey("jun");
        assertThat(car.getCars()).containsValue(0);
    }

    @Test
    void splitNames_메서드로_구분된_각각의_이름_길이가_5초과시_에러() {
        input = "pobi,woni,junnnn";

        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하로만 가능합니다.");
    }

    @Test
    void forward_자동차_전진() {
        Map<String, Integer> result = car.getCars();
        Iterator<Map.Entry<String, Integer>> iterator = result.entrySet().iterator();

        while (iterator.hasNext()) {
            car.forward(iterator.next());
        }

        for (String key : result.keySet()) {
            assertThat(result.get(key)).isEqualTo(1);
        }
    }
}
