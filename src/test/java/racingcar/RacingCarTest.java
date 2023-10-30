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
}
