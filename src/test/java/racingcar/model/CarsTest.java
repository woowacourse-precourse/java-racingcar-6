package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.utils.Constraints;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {
    @Test
    void 길이_초과_자동차명() {
        String carNames = "Hot, HotFriedDelicious";

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(Constraints.MAX_SIZE.getValue()));
    }

    @Test
    void 길이_0_자동차명() {
        String carNames = "Hot, ";

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(Constraints.MIN_SIZE.getValue()));
    }

    @Test
    void 중복된_자동차명() {
        String carNames = "Car1, Car2, Car1";

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 존재 합니다.");
    }

    @Test
    void 자동차객체_저장_확인() {
        String carNames = "Car1,Car2,Car3";
        Cars cars = new Cars(carNames);

        List<Car> result = cars.getCars();
        String[] carNamesArray = carNames.split(",");

        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i).getName()).isEqualTo(carNamesArray[i]);
        }
    }
}