package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

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
