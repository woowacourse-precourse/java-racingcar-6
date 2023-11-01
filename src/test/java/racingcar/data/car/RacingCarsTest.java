package racingcar.data.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {
    @DisplayName("자동차 이름 1보다 짧은 경우 테스트")
    @Test
    void validateRacingCarsName_shorterThan1_IAE() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 0));
        String name = "";

        // when, then
        assertThatThrownBy(() -> RacingCars.validateRacingCarsName(cars, name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("CarName cannot be empty.");
    }

    @DisplayName("자동차 이름 0보다 긴 경우 테스트")
    @Test
    void validateRacingCarsName_longerThan0_OK() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 0));
        String name = "jun";

        // when, then
        assertThatCode(() -> RacingCars.validateRacingCarsName(cars, name))
                .doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름 중복 테스트")
    @Test
    void validateRacingCarsName_duplicate_IAE() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 0));
        String name = "pobi";

        // when, then
        assertThatThrownBy(() -> RacingCars.validateRacingCarsName(cars, name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("CarNames should be distinct.");
    }

    @DisplayName("자동차 이름 중복 없는 테스트")
    @Test
    void validateRacingCarsName_distinct_OK() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 0));
        String name = "woni";

        // when, then
        assertThatCode(() -> RacingCars.validateRacingCarsName(cars, name))
                .doesNotThrowAnyException();
    }
}
