package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 전진_성공() {
        //given
        Car car = new Car("pobi");
        //when
        car.move(4);
        //then
        assertThat(car.getMoveStatus()).isEqualTo(1);
    }

    @Test
    void 전진_실패() {
        //given
        Car car = new Car("pobi");
        //when
        car.move(3);
        //then
        assertThat(car.getMoveStatus()).isEqualTo(0);
    }

    @Test
    void 전진_여러번() {
        //given
        Car car = new Car("pobi");
        //when
        IntStream.rangeClosed(1, 9)
                .forEach(car::move);
        //then
        assertThat(car.getMoveStatus()).isEqualTo(6);
    }
}
