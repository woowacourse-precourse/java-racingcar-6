package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 중복된_자동차_이름_확인() {
        String[] stringArray = {"A", "A", "B"};
        assertThatThrownBy(() -> new Cars(stringArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름을 입력하였습니다.");
    }

    @Test
    void 가장_멀리있는_자동차_위치_확인() {
        String[] carArray = {"벤츠", "아우디", "BMW", "페라리"};
        List<String> carList = new ArrayList<>(List.of(carArray));
        Cars cars = new Cars(carArray);
        assertThat(cars.getMaxPosition()).isEqualTo(0);

    }
    @Test
    void 우승_자동차_확인() {
        String[] carArray = {"벤츠", "아우디", "BMW", "페라리"};
        List<String> carList = new ArrayList<>(List.of(carArray));
        Cars cars = new Cars(carArray);
        assertThat(cars.getVictoryCarsName()).isEqualTo(carList);
    }
}