package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    @DisplayName("Car_객체_생성")
    void createCars() {
        String input = "test";

        Car result = new Car(input);

        assertEquals("test", result.getName());
        assertEquals(0, result.getDistance());
    }

    @Test
    @DisplayName("Car_객체_생성_글자수_초과_예외")
    void createCarNameExceededException() {
        String input = "test66";

        Assertions.assertThatThrownBy(
                        () -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_MAX_LENGTH_EXCEEDED
                        .getErrorMessage());
    }

    @Test
    @DisplayName("Car_객체_생성_글자수_비어있음_예외")
    void createCarNameEmptyException() {
        String input = "";

        Assertions.assertThatThrownBy(
                        () -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_NAME
                        .getErrorMessage());
    }

//    @Test
//    @DisplayName("Car_이동")
//    void moveCar() {
//        Car car = new Car("test");
//
//        Randoms randoms = mock(Randoms.class);
//
//        when(randoms.pickNumberInRange(0, 9)).thenReturn(5);
//        car.move();
//
//        assertEquals(1, car.getDistance());
//    }
}
