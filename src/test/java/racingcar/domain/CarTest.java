package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static Car car = new Car("pobi", 1);
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
}
