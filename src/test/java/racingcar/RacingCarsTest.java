package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("레이싱 카 테스트")
class RacingCarsTest {

    @Test
    @DisplayName("하나라도 차 글자가 5글자가 이상인 경우 RacingCars 생성 실패")
    void createRacingCars() {
        List<String> namesOfCars = List.of("jdj", "djsjs", "vdmmds");
        assertThatThrownBy(() -> new RacingCars(namesOfCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name length should be under " + RacingCars.MAX_NAME_LENGTH);

    }
}