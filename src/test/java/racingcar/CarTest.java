package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    void 전진_명령() {
        Car car = new Car("민수");
        car.addPosition();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
