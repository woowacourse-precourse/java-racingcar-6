package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.RandomGenerator;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("3를 발생시키는 NumberGenerator 주입")
    void 랜덤값_4미만이면_움직이지_않음() {
        Car car = new Car("abc", () -> 3);
        car.moveByRandomNumber();
        Assertions.assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("4를 발생시키는 NumberGenerator 주입")
    void 랜덤값_4이상이면_움직임() {
        Car car = new Car("abc", () -> 4);
        car.moveByRandomNumber();
        Assertions.assertEquals(1, car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "def", "ghi"})
    void 차이름_테스트(String input) {
        Car car = new Car(input, new RandomGenerator());
        Assertions.assertEquals(input, car.getCarName());
    }
}