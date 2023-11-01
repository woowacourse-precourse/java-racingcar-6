package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void Car_생성시_초기화_성공() throws Exception {
        //given
        String carName = "pobi";

        //when
        Car car = new Car(carName);
        //then
        Assertions.assertThat(car.getPosition())
                .isEqualTo(0);
    }
}
