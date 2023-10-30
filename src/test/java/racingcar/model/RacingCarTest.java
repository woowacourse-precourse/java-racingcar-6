package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @DisplayName("자동차 전진 기능")
    @Test
    void move() {
        RacingCar racingCar = new RacingCar("name");
        racingCar.move(3);
        assertThat(racingCar.toString()).isEqualTo("name : ");
        racingCar.move(4);
        assertThat(racingCar.toString()).isEqualTo("name : -");
    }

    @DisplayName("자동차 이름 짓기")
    @Test
    void naming() {
        assertThatThrownBy(() -> new RacingCar("Kailyn")).isInstanceOf(IllegalArgumentException.class);
    }
}