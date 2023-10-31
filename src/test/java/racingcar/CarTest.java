package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domain.Car;
import racingcar.service.CarService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private CarService carService = new CarService();
    @DisplayName("자동차 이름이 중복이면 예외가 발생한다.")
    @Test
    void duplicateCarName() {
        assertThatThrownBy(()-> carService.stringToList("stlla,stlla"))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("자동차 이름이 빈값이면 예외가 발생한다.")
    @Test
    void emptyCarName() {
        assertThatThrownBy(()-> carService.stringToList(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @DisplayName("자동차 이름이 null 또는 empty 일 경우 예외가 발생한다.")
    @NullAndEmptySource
    void nullOrEmptyCarName(String carName) {
        assertThatThrownBy(() -> carService.stringToList(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("자동차 이름이 null이면 예외가 발생한다.")
    @Test
    void nullCarName() {
        assertThatThrownBy(()-> carService.stringToList(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생한다.")
    @Test
    void overLengthCarName() {
        assertThatThrownBy(() -> carService.stringToList("abcdefg,abcde"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("알맞은 자동차 이름은 입력에 성공한다.")
    @Test
    void successCarName() {
        List<Car> cars = carService.initRacingCars(List.of("stella,jay"));
        assertThat(cars.equals(Arrays.asList(new Car("stella"),new Car("jay"))));
    }
}
