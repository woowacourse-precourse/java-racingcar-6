package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class CarTest {
    private final static int MOVE_NUM = 4;
    private final static int SUCCESS_MOVE_DISTANCE = 1;

    @Test
    @DisplayName("Car_객체_생성")
    void createCars() {
        String input = "test";

        Car result = new Car(input);

        assertThat(result.getName())
                .isEqualTo("test");
        assertThat(result.getDistance())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("Car_객체_생성_글자수_초과_예외")
    void createCarNameExceededException() {
        String input = "test66";

        assertThatThrownBy(
                () -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_MAX_LENGTH_EXCEEDED
                        .getErrorMessage());
    }

    @Test
    @DisplayName("Car_객체_생성_글자수_비어있음_예외")
    void createCarNameEmptyException() {
        String input = "";

        assertThatThrownBy(
                () -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_NAME
                        .getErrorMessage());
    }

    @Test
    @DisplayName("Car_이동")
    void moveCar() {
        Car car = new Car("test");

        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance())
                            .isEqualTo(SUCCESS_MOVE_DISTANCE);
                },
                MOVE_NUM
        );
    }
}
