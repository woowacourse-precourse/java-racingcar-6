package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;
    private Car otherCar;

    @BeforeEach
    void init() {
        car = Car.from("nara");
        otherCar = Car.from("otherCar");
    }

    @Test
    void 정적_팩토리_객체가_생성되는지_확인() {
        assertThat(car.getName() == "nara");
    }

    @Test
    void 랜덤값이_4이상이면_자동차_전진() {
        car.movePosition(4);
        int compareNumber = car.compareTo(otherCar);

        assertThat(compareNumber).isEqualTo(1);
    }

    @Test
    void 랜덤값이_3이하면_자동차_정지() {
        car.movePosition(3);
        int compareNumber = car.compareTo(otherCar);

        assertThat(compareNumber).isEqualTo(0);
    }

    @Test
    void 자동차의_위치가_같으면_true_반환_확인() {
        boolean isSame = car.isSamePosition(otherCar);

        assertThat(isSame).isTrue();
    }

    @Test
    void 자동차의_위치가_다르면_false_반환_확인() {
        car.movePosition(7);
        boolean isSame = car.isSamePosition(otherCar);

        assertThat(isSame).isFalse();
    }
}