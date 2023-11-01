package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void create_차량_생성_시_이름_설정() {
        //given
        String carName = "test";

        //when
        Car car = new Car(carName);

        //then
        Assertions.assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void create_차량_생성_시_거리는_0() {
        //given
        String carName = "test";

        //when
        Car car = new Car(carName);

        //then
        Assertions.assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void run_랜덤_숫자가_4_이상_시_거리_증가() {
        //given
        String carName = "test";
        Car car = new Car(carName);
        int preDistance = car.getDistance();

        //when
        car.run(MOVING_FORWARD);

        //then
        Assertions.assertThat(car.getDistance()).isEqualTo(preDistance + 1);
    }

    @Test
    void run_랜덤_숫자가_3_이하_시_거리_유지() {
        //given
        String carName = "test";
        Car car = new Car(carName);
        int preDistance = car.getDistance();

        //when
        car.run(STOP);

        //then
        Assertions.assertThat(car.getDistance()).isEqualTo(preDistance);
    }
}
