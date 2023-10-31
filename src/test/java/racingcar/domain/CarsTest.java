package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.dto.RoundResult;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    void 자동차_이름_배열_반환() {
        Cars cars = new Cars(Arrays.asList("pobi", "crong", "honux"));
        assertThat(cars).isEqualTo(new Cars(Arrays.asList("pobi", "crong", "honux")));
    }

    @Test
    void 자동차_레이싱_후_결과를_반환한다(){
        Cars cars = new Cars(Arrays.asList("pobi", "crong", "honux"));
        cars.race();
        assertThat(cars.race()).isInstanceOf(RoundResult.class);
    }
}