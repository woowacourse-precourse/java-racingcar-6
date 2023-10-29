package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setup() {
        car = new Car("gyuwon");
    }

    @RepeatedTest(value = 10000)
    public void 랜덤값_생성_테스트() {
        //when
        int randomNumber = car.generateRandomNumber();

        //then
        assertThat(randomNumber).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 정지_테스트(int randomNumber) {
        //when
        car.moveOrStop(randomNumber);

        //then
        assertThat(car.getLocationForTest()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 이동_테스트(int randomNumber) {
        //when
        car.moveOrStop(randomNumber);

        //then
        assertThat(car.getLocationForTest()).isEqualTo(1);
    }
}
