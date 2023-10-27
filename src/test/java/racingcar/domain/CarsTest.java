package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 중복된_자동차_이름_확인() {
        String[] stringArray = {"A", "A", "B"};
        assertThatThrownBy(() -> new Cars(stringArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름을 입력하였습니다.");
    }

}