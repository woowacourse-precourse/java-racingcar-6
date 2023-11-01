package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    @Test
    @DisplayName("자동차가 전진하면 위치가 1 증가한다.")
    void CarMoveTest() {
        Car car = new Car("pobi");
        int beforePosition = car.getPosition();
        boolean isMove = true;
        car.move(isMove);
        int afterPosition = car.getPosition();
        Assertions.assertThat(afterPosition).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("자동차가 전진하지 않는다.")
    void CarStopTest() {
        Car car = new Car("pobi");
        int beforePosition = car.getPosition();
        boolean isMove = false;
        car.move(isMove);
        int afterPosition = car.getPosition();
        Assertions.assertThat(afterPosition).isEqualTo(beforePosition);
    }
}
