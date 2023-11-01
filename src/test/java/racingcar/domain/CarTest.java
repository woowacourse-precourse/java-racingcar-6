package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Iterator;
import java.util.Map;

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
        Iterator<Map.Entry<String, Integer>> iterator = car.getCars().entrySet().iterator();
        Map.Entry<String, Integer> next;

        next = iterator.next();
        car.forward(next, 5);
        assertThat(next.getValue()).isEqualTo(1);   // poni 전진

        next = iterator.next();
        car.forward(next, 1);
        assertThat(next.getValue()).isEqualTo(0);   // woni 정지

        next = iterator.next();
        car.forward(next, 8);
        assertThat(next.getValue()).isEqualTo(1);   // jun 전진
    }

    @ParameterizedTest
    @CsvSource({"2,false", "4,true", "1,false", "5,true", "8,true", "3,false"})
    void isForward_전진_가능_여부(int randomNumber, boolean expected) {
        assertThat(car.isForward(randomNumber)).isEqualTo(expected);
    }
}
