package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Name;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"woooni", "", "hihihihihi"})
    @DisplayName("자동차 이름이 6자 이상이거나, 0자이면 실패")
    void validateCarNameValid_실패(String input) {
        assertThatThrownBy(() -> Name.validateCarNameValid(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"woni", "p", "pobi"})
    @DisplayName("자동차 이름이 1~5자이면 성공")
    void validateCarNameValid_성공(String input) {
        Car car = new Car(input);
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 실패")
    void validateUniqueCarName_실패() {
        assertThatThrownBy(() -> Cars.validateUniqueCarName(new String[]{"pobi", "wooni", "pobi"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,wooni,abcde"})
    @DisplayName("자동차 이름이 고유하면 성공")
    void validateUniqueCarName_성공(String input) {
        Cars cars = new Cars(input);
        assertThat(cars).isNotNull();
    }
}
