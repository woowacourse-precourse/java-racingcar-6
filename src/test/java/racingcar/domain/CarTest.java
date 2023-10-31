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
}