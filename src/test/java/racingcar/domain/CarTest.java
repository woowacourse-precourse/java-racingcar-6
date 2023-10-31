package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 정적_팩토리_객체가_생성되는지_확인() {
        Car car = Car.nameFrom("nara");
        assertThat(car.getPosition() == 0);
    }

    @Test
    void 랜덤값이_4이상일경우_전진() {
        Car car = Car.nameFrom("nara");
        car.play();
        System.out.println(car.getPosition());
    }

    @Test
    void 자동차객체의_position에_따른_전진값_출력_확인() {
        Car car = Car.nameFrom("nara");
        car.play();
        car.play();
        System.out.println(car.getPosition());
        car.printGameProceed();
    }
}