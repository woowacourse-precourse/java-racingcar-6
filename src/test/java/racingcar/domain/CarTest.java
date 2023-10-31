package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = Car.from("nara");
    }

    @Test
    void 정적_팩토리_객체가_생성되는지_확인() {
        assertThat(car.getName() == "nara");
    }

    @Test
    void 자동차객체의_position에_따른_전진값_출력_확인() {
        car.play();
        car.play();
        car.printGameProceed();
    }

    @Test
    void 자동차의_위치가_같으면_true_반환_확인() {
        Car otherCar = Car.from("other");
        boolean isSame = car.isSamePosition(otherCar);

        assertThat(isSame).isTrue();
    }

    @Test
    void 자동차의_위치가_다르면_false_반환_확인() {
        Car otherCar = Car.from("other");
        otherCar.play();
        otherCar.play();

        boolean isSame = car.isSamePosition(otherCar);

        assertThat(isSame).isTrue();
    }
}