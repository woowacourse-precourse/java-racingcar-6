package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.errormessage.InputError;
import racingcar.model.Car;
import racingcar.view.CarsInputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("정상입력")
    @Test
    void isCorrectInput(){
        //given
        Car car1 = new Car("pobi",0);
        Car car2 = new Car("woni",0);
        Car car3 = new Car("jun",0);
        List<Car> inputCars = Arrays.asList(car1, car2, car3);

        //when
        Cars cars = new Cars(inputCars);

        //then
        Assertions.assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @DisplayName("빈문자열_입력")
    @Test
    void isEmpty() {
        // Given
        List<Car> inputCars = Arrays.asList();

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Cars(inputCars));

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_EMPTY_ERROR_MESSAGE);
    }

    @DisplayName("5글자_초과_입력")
    @Test
    void isOverLength() {
        // Given
        Car car = new Car("pobieee",0);
        List<Car> inputCars = Arrays.asList(car);

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Cars(inputCars));

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_NAME_LENGTH_ERROR_MESSAGE);
    }
}