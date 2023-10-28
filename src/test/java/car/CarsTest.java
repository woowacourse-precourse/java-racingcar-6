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

    // TODO: 2023/10/28 이 테스트 매서드를 위해 쓸모없는 매서드가 Cars 에 남아도 괜찮은걸까?
    @Test
    @DisplayName("동작 검증만을 위한 테스트")
    void carList_move_test() {
        Cars cars = new Cars(NORMAL_INPUT);
        cars.moveForTest();
        for (Car car : cars.getCarList()) {
            assertThat(car.getLocation()).isOne();
        }
    }
}