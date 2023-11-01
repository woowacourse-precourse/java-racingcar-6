package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void 올바른_이름이_주어질_때_정상적으로_자동차_인스턴스_생성된다() {
        String validName = "pobi";
        int defaultForwardCount = 0;
        RacingCar car = new RacingCar(validName);

        assertThat(car.getName()).isEqualTo(validName);
        assertThat(car.getForwardCount()).isEqualTo(defaultForwardCount);
    }

    @Test
    void 이름이_올바르지_않을_때_예외가_발생한다() {
        String blankName = "";
        String overLengthName = "over_length";

        assertThatThrownBy(() -> new RacingCar(blankName))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RacingCar(overLengthName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_move_시_파라미터의_값이_기준보다_높다면_이동한다() {
        RacingCar car = new RacingCar("name");
        int prevForwardCount = car.getForwardCount();
        int overMovementWeight = 7;

        car.move(overMovementWeight);
        assertThat(car.getForwardCount()).isEqualTo(prevForwardCount + 1);
    }

    @Test
    void 자동차_move_시_파라미터의_값이_기준보다_낮다면_이동하지_않는다() {
        RacingCar car = new RacingCar("name");
        int prevForwardCount = car.getForwardCount();
        int underMovementWeight = 3;

        car.move(underMovementWeight);
        assertThat(car.getForwardCount()).isEqualTo(prevForwardCount);
    }
}
