package racingcar.validator;

import org.junit.jupiter.api.Test;
import racingcar.domain.RandomCar;

import static org.assertj.core.api.Assertions.assertThat;

class RandomCarTest {

    @Test
    void 자동차가_움직이는_기능_테스트() {
        RandomCar car4 = new RandomCar("랜덤값이 4만 나오는 자동차", () -> 4);
        RandomCar car3 = new RandomCar("랜덤값이 3만 나오는 자동차", () -> 3);

        int repeat = 10;
        int car4Position = 0;
        int car3Position = 0;

        for (int i = 0; i < repeat; i++) {
            car4Position = car4.move();
            car3Position = car3.move();
        }

        assertThat(car4Position).isEqualTo(repeat);
        assertThat(car3Position).isEqualTo(0);
    }
}

