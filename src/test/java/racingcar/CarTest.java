package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void create_차량_생성_시_이름_설정(){
        //given
        String carName = "test";

        //when
        Car car = Car.create(carName);

        //then
        Assertions.assertThat(car.getName()).isEqualTo(carName);
    }
    @Test
    void create_차량_생성_시_거리는_0(){
        //given
        String carName = "test";

        //when
        Car car = Car.create(carName);

        //then
        Assertions.assertThat(car.getDistance()).isEqualTo(0);
    }
}
