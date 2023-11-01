package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.util.RangedRandomNumberPicker;

public class RacingCarTest {

    @Test
    void 자동차는_전진할_수_있다() {
        RangedRandomNumberPicker RandomNumberPickerOver4  = new RangedRandomNumberPicker(4, 9);
        RacingCar racingCar = new RacingCar("name", RandomNumberPickerOver4);
        int initialCarPosition = racingCar.getPosition();

        racingCar.race();
        int currentCarPosition = racingCar.getPosition();
        assertThat(currentCarPosition).isEqualTo(initialCarPosition + 1);
    }

    @Test
    void 자동차는_이동_조건이_만족되지_않으면_이동하지_않을_수도_있다() {
        RangedRandomNumberPicker RandomNumberPickerUnder4  = new RangedRandomNumberPicker(0, 3);
        RacingCar racingCar = new RacingCar("name", RandomNumberPickerUnder4);
        int initialCarPosition = racingCar.getPosition();

        racingCar.race();
        int currentCarPosition = racingCar.getPosition();
        assertThat(currentCarPosition).isEqualTo(initialCarPosition);
    }
}
