package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차가_움직이는_기능_테스트() {
        Car car4 = new Car("랜덤값이 4만 나오는 자동차", () -> 4);
        Car car3 = new Car("랜덤값이 3만 나오는 자동차", () -> 3);

        int repeat = 10;
        int car3Position = 0;
        int car4Position = 0;

        for (int i = 0; i < repeat; i++ ) {
            car3Position = car4.move();
            car4Position = car3.move();
        }

        assertThat(car3Position).isEqualTo(repeat);
        assertThat(car4Position).isEqualTo(0);
    }

}

