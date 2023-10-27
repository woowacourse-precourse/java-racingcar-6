package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constraints;

class CarsTest {
    @Test
    void 길이_초과_자동차명() {
        List<String> carNames = Arrays.asList("Hot", "HotFriedDelicious");

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 " + Constraints.MAX_SIZE.getValue() + "보다 작아야 합니다.");
    }

    @Test
    void 중복된_자동차명() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car1");

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 존재 합니다.");
    }

    @Test
    void carsNameMatchesCarNames() {
        // 준비
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        Cars cars = new Cars(carNames);

        // 실행
        List<Car> result = cars.getCars();

        // 단언
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i).getName()).isEqualTo(carNames.get(i));
        }
    }
}