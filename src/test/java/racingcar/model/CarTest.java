package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class CarTest {

    @Test
    void 자동차_Set_Get_테스트() {
        Car car = new Car();

        car.setCar(List.of("dokgo", "may", "cat", "uncle", "king"));

        assertThat(car.getCar()).isEquals("dokgo", "may", "cat", "uncle", "king");
    }
}
