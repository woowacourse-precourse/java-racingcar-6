package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.TestHelper.genearteCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;

public class CarTest {

    @Test
    @DisplayName("같은 위치인지 비교한다.")
    public void 같은_위치인지_비교한다() {
        //given
        Car car = genearteCar();
        Car otherCar = genearteCar();

        //when
        boolean isSamePosition = car.isSamePosition(otherCar);

        //then
        assertThat(isSamePosition).isTrue();
    }
}
