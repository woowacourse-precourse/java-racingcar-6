package racingcar.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarControllerTest {
    private CarController carController;

    @BeforeEach
    void setUp() {
        carController = new CarController();
    }

    @Test
    void 자동차_이름_입력_유효성_검사_정상() {
        String playerInput = "dog,cat,bear";
        List<Car> expectedCarNames = Arrays.asList(new Car("dog"), new Car("cat"), new Car("bear"));
        assertThat(carController.getRacingCars(playerInput))
                .usingRecursiveComparison()
                .ignoringFields("record")
                .isEqualTo(expectedCarNames);
    }

    @Test
    void 자동차_이름_입력_유효성_검사_1대일_경우() {
        String playerInput = "dog";
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> carController.getRacingCars(playerInput));
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.NAMES_COUNT_EXCEPTION_MESSAGE.get());
    }

    @Test
    void 자동차_이름_입력_유효성_검사_글자수_범위를_벗어날_경우() {
        String playerInput = "dog,elephant,cat";
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> carController.getRacingCars(playerInput));
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.NAME_LENGTH_EXCEPTION_MESSAGE.get());
    }

    @Test
    void 자동차_이름_입력_유효성_검사_중복일_경우() {
        String playerInput = "dog,dog";
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> carController.getRacingCars(playerInput));
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.NAME_DUPLICATION_EXCEPTION_MESSAGE.get());
    }
}