package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarGameController;

public class EnterRacingCarNameTest {
    @Test
    void RacingCar_이름의_길이가_알맞을_때1() {
        String input = "12345,123,321";

        Assertions.assertDoesNotThrow(() -> RacingCarGameController.parseRacingCarNames(input));
    }

    @Test
    void RacingCar_이름의_길이가_알맞을_때2() {
        String input = "123,32";

        Assertions.assertDoesNotThrow(() -> RacingCarGameController.parseRacingCarNames(input));
    }

    @Test
    void RacingCar_이름의_길이가_알맞지_않을_때1() {
        String input = "12345,123456,321";

        assertThatThrownBy(() -> RacingCarGameController.parseRacingCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ERR_RACING_CAR_NAME_LENGTH);
    }

    @Test
    void RacingCar_이름의_길이가_알맞지_않을_때2() {
        String input = "jaesang,woote";

        assertThatThrownBy(() -> RacingCarGameController.parseRacingCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ERR_RACING_CAR_NAME_LENGTH);
    }
}
