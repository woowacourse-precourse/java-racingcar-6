package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarsController;
import racingcar.controller.CarsCreator;
import racingcar.model.Cars;

public class InputNameTest {
    CarsCreator carsCreator = new CarsController();

    @Test
    void createCars_확인1() {
        Cars cars = carsCreator.createCars("1,2,3,4,56789");
        List<String> carsNames = cars.getCars()
                .stream()
                .map(car -> car.name)
                .toList();
        List<String> expected = Arrays.asList("1", "2", "3", "4", "56789");

        assertThat(carsNames).isEqualTo(expected);
    }

    @Test
    void inputName_5자_초과_에러() {
        assertThatThrownBy(() -> carsCreator.createCars( "a,abcdefg"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> carsCreator.createCars("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputName_빈문자열_에러() {
        assertThatThrownBy(() -> carsCreator.createCars(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> carsCreator.createCars(",,"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
