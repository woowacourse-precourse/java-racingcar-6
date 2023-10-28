package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;

public class CarTest {

    private static Car car;

    @BeforeAll
    public static void setup() {
        car = new Car("gyuwon");
    }


    @RepeatedTest(value = 10000)
    public void 랜덤값_생성_테스트() {
        //when
        int randomNumber = car.generateRandomNumber();

        //then
        assertThat(randomNumber).isBetween(0, 9);
    }
}
