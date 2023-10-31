package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomCarTest {

    @Test
    void 자동차가_움직이는_기능_테스트() {
        RandomCar car4 = new RandomCar("랜덤값이 4만 나오는 자동차", () -> 4);
        RandomCar car3 = new RandomCar("랜덤값이 3만 나오는 자동차", () -> 3);

        int repeat = 10;
        int car3Position = 0;
        int car4Position = 0;

        for (int i = 0; i < repeat; i++) {
            car3Position = car4.move();
            car4Position = car3.move();
        }

        assertThat(car3Position).isEqualTo(repeat);
        assertThat(car4Position).isEqualTo(0);
    }
}

