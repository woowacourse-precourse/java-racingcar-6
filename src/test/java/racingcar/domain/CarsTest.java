package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    @DisplayName("자동차 리스트 생성 성공")
    public void create() {
        // given
        String names = "race,car,coin";

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("이름이 중복될 경우, 자동차 리스트 생성 실패")
    public void createFail() {
        // given
        String names = "race,car,car";

        // when
        // then
        assertThatThrownBy(() -> new Cars(names))
            .isInstanceOf(IllegalArgumentException.class);
    }


}