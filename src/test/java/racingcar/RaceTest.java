package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Race;

import static org.assertj.core.api.Assertions.*;

public class RaceTest {

    @Test
    void 자동차_이름이_정상적으로_입력되지_않은_경우() {
        String nameIsNull = null;
        String nameIsEmpty = "";
        String nameIsBlank = " ";
        String nameIsLong = "looooong";

        assertThatThrownBy(() -> new Race(nameIsNull, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Race(nameIsEmpty, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Race(nameIsBlank, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Race(nameIsLong, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_수가_4이상일때_카운팅하는_경우() {
        Car car = new Car("ford");
        int random = Randoms.pickNumberInRange(0, 9);
        car.move(random);

        if (random >= 4) {
            assertThat(car.getCount()).isEqualTo(1);
        } else {
            assertThat(car.getCount()).isEqualTo(0);
        }
    }
}
