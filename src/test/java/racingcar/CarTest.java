package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @ParameterizedTest
    @ValueSource(strings = {"amy", "rose", "lisa"})
    @DisplayName("이름 길이에 문제 없는 경우")
    void 정상적인_경우(String name) {
        Assertions.assertThat(new Car(name));
    }

    @Test
    @DisplayName("이름 길이 초과 확인")
    public void carNameShouldBeLongerThan5() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Car("abcdef");
        });
    }

    @Test
    @DisplayName("자동차 이동 o")
    public void carShouldMove() {
        Car car = new Car("amy");
        car.run(MOVING_FORWARD);
        assertThat(car.getMove()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이동 x")
    public void carShouldNotMove() {
        Car car = new Car("amy");
        car.run(STOP);
        assertThat(car.getMove()).isEqualTo(0);
    }

}