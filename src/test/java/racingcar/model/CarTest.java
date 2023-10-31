package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 자동차_생성() {
        // given
        String name = "test1";
        // when
        Car car = new Car(name);
        // then
        assertThat(car).isNotNull();
    }
}
