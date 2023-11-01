package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private String carName = "pobi";
    private int carBoost = 0;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(carName);
    }

    @Test
    void carBoost_4이상일때_moveForward() {
        //given (주어진 값)
        carBoost = 4;

        //when
        car.moveForward(carBoost);

        //then (기능 작동 후 검증)
        assertThat(car.getCarBoost()).isEqualTo(1);    //랜덤값 개수를 검증

    }

    @Test
    void carBoost_4미만일때_moveForward() {
        //given (주어진 값)
        carBoost = 3;

        //when
        car.moveForward(carBoost);

        //then (기능 작동 후 검증)
        assertThat(car.getCarBoost()).isEqualTo(0);    //랜덤값 개수를 검증

    }

}