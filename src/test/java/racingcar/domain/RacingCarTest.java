package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @DisplayName("move()로 randomNumber가 전진하는 조건인 4 이상이라면 position이 1 증가한다.")
    @Test
    void move_with_valid_random_number() {
        // given
        RacingCar racingCar = new RacingCar("sully");

        // when
        racingCar.move(4);

        // then
        assertThat(racingCar.createMaxPosition()).isEqualTo(1);
    }

    @DisplayName("move()로 randomNumber가 전진하는 조건인 4 이상이 아니라면 position이 증가하지 않는다.")
    @Test
    void move_with_invalid_random_number() {
        // given
        RacingCar racingCar = new RacingCar("sully");

        // when
        racingCar.move(3);

        // then
        assertThat(racingCar.createMaxPosition()).isZero();
    }

}
