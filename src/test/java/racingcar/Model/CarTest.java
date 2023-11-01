package racingcar.Model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Controller.RacingGame;
import racingcar.View.SystemIn;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    public Car car;

    @Test
    @DisplayName("자동차 이름 5글자 초과 시")
    void input() {
        String name = "abcdef";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 이름 5글자 초과일 경우");
    }

}