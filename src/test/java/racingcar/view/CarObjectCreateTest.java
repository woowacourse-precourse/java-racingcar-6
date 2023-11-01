package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarObjectCreateTest {

    @Test
    void 자동차_객체_생성_테스트(){

        // given
        String input = "pobi";

        // when
        Car car = Car.create(input);

        // then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);

    }
}
