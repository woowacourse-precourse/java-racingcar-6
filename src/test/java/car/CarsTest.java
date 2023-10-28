package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    private static final String NORMAL_INPUT = "pobi,json,DK";
    private static final String[] USERNAME_ARRAY = NORMAL_INPUT.split(",");
    @Test
    void cars_init_test_NORMAL_CASE(){
        Cars cars = new Cars(NORMAL_INPUT);
        assertThat(cars.getCarList()).hasSize(3);
        assertThat(cars.getCarNames()).isEqualTo(List.of(USERNAME_ARRAY));
    }

    @ParameterizedTest
    @DisplayName("유저의 입력에서 공백을 제거한다.")
    @ValueSource(strings = {"pobi,     json,   DK", "pobi,          json, DK"})
    void cars_init_with_spaces(String userInputWithBlank) {
        Cars cars = new Cars(userInputWithBlank);
        assertThat(cars.getCarList()).hasSize(3);
        assertThat(cars.getCarNames()).isEqualTo(List.of(USERNAME_ARRAY));
    }

    @ParameterizedTest
    @DisplayName("공백만 입력하거나, 공백인 유닛이 있어선 안된다.")
    @ValueSource(strings = {" ", ", ", "pobi, json, Dk,   "})
    void car_name_must_not_blank(String invalidInput) {
        assertThatThrownBy(() -> new Cars(invalidInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이름이 5자를 초과해선 안된다.")
    @ValueSource(strings = {"looooooong", "helloWorld", "SpringBoot", "I_AM_IRON_MAN"})
    void invalid_name_length(String longNameInput) {
        assertThatThrownBy(() -> new Cars(longNameInput)).isInstanceOf(IllegalArgumentException.class);
    }
}