package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static final String VALID_NAME = "pobi";

    @Test
    void 자동차_정상_생성() {
        //given
        Name validName = new Name(VALID_NAME);

        //when
        Car car = new Car(validName);

        //then
        assertThat(car.getName()).isEqualTo(validName.value());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전진() {
        //given
        Car car = new Car(new Name(VALID_NAME));
        MoveCondition condition = MoveCondition.MOVE;

        //when
        car.updatePositionBy(condition);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
