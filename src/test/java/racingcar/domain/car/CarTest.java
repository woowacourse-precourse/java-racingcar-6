package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Constant.*;

class CarTest {

    private static final String CAR_NAME = "test";
    private static final int CAR_POINT = 5;
    Car car;


    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME);
    }

    @Test
    @DisplayName("점수_0점일때_toString_확인")
    public void toString_whenPointIsZero_checkOutput() {
        //given
        String expected = CAR_NAME + IS;

        //when
        String actual = car.toString();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("점수_존재할_때_toString_확인")
    public void toString_whenPointIsNotZero_checkOutput() {
        //given
        for (int i = 0; i < CAR_POINT; i++) {
            car.forward();
        }
        String expected = CAR_NAME + IS + LINE.repeat(CAR_POINT);

        //when
        String actual = car.toString();

        //then
        assertThat(actual).isEqualTo(expected);
    }

}