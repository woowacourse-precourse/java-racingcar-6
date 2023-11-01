package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private static final int START_LOCATION = 0;

    @Test
    public void 차_생성_테스트() {
        //given
        String carName = "pobi";

        //when
        Car createdCar = Car.createWithName(carName);

        //then
        assertThat(createdCar.getName()).isEqualTo(carName);
        assertThat(createdCar.getLocation()).isEqualTo(START_LOCATION);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 정지_테스트(int randomNumber) {
        //given
        Car car = Car.createWithName("pobi");

        //when
        car.moveOrStop(randomNumber);

        //then
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 이동_테스트(int randomNumber) {
        //given
        Car car = Car.createWithName("pobi");

        //when
        car.moveOrStop(randomNumber);

        //then
        assertThat(car.getLocation()).isEqualTo(1);
    }
}
