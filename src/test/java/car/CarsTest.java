package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    void cars_init_with_spaces() {
        String userInputWithBlank = "pobi, json, DK";
        Cars cars = new Cars(userInputWithBlank);
        assertThat(cars.getCarList()).hasSize(3);
        assertThat(cars.getCarNames()).isEqualTo(List.of(USERNAME_ARRAY));
    }

    @Test
    void car_name_must_not_blank() {
        String blankedOneInput = " ";
        String blankExistsInNameArray = "json, pobi, DK,      ";
        assertThatThrownBy(() -> new Cars(blankedOneInput)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(blankExistsInNameArray)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid_name_length() {
        String longNameInput = "helloWorld, SpringBoot, I_AM_IRON_MAN";
        assertThatThrownBy(() -> new Cars(longNameInput)).isInstanceOf(IllegalArgumentException.class);
    }
}