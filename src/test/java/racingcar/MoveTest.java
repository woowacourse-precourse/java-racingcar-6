package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.Car;

public class MoveTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(
                new Car("car1", 0),
                new Car("car2", 0),
                new Car("car3", 0)
        );
    }

    @Test
    void 번호가_4_이상이면_전진() {
        Car car = new Car("jun", 0);

        // given
        int randomNum = 5;
        //when
        if (randomNum >= 4) {
            car.move();
        }
        //then
        assertThat(car.getLength()).isEqualTo(1);
    }

    @Test
    void 번호가_4_미만이면_전진x() {
        Car car = new Car("jun", 0);

        //given
        int randomNum2 = 3;

        //when
        if (randomNum2 >= 4) {
            car.move();
        }

        //then
        assertThat(car.getLength()).isEqualTo(0);
    }

    @Test
    void 여러_객체_전진_테스트() {

        //given
        int num = 5;

        //when
        for (Car car : cars) {
            if (num >= 4) {
                car.move();
            }
        }

        //then
        for (Car car : cars) {
            assertThat(car.getLength()).isEqualTo(1);
        }
    }
}














