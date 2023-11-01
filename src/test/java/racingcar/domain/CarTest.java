package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static Car car = new Car("pobi", 1);
    private final int FORWARD_LIMIT = 4;
    @Test
    void isMoreThanDigit_num이_digit_이상() {
        assertThat(car.isMoreThanDigit(3, 4))
                .isTrue();
    }

    @Test
    void isMoreThanDigit_num이_digit과_동일() {
        assertThat(car.isMoreThanDigit(3, 3))
                .isTrue();
    }

    @Test
    void isMoreThanDigit_num이_digit_이하() {
        assertThat(car.isMoreThanDigit(4, 3))
                .isFalse();
    }

    @Test
    void forward_랜덤값이_4() {
        car.forward(4,FORWARD_LIMIT);
        assertThat(car.getCurrent()).isEqualTo(2);
    }

    @Test
    void forward_랜덤값이_3() {
        car.forward(3, FORWARD_LIMIT);
        assertThat(car.getCurrent()).isEqualTo(1);
    }
}
