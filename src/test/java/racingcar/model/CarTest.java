package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

class CarTest {

    @Test
    public void car_객체는_이름을_통해_생성() throws Exception {
        //given
        String name = "test";
        //when
        Car car = new Car(name);
        //then
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    public void car_이름_유효성_검증() throws Exception {
        String invalidName = "testCar";

        assertThatThrownBy(() -> {
            new Car(invalidName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME.getMessage());
    }
}