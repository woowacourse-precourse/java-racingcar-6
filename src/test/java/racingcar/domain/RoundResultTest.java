package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RoundResultTest {

    @DisplayName("라운드 별 자동차들의 위치를 가지는 객체를 생성한다.")
    @Test
    void createRoundResult() {
        // given
        Cars cars = new Cars(List.of("pobi","crong","honux"));

        // when
        RoundResult roundResult = new RoundResult(cars.getCurrentStatus());

        // then
        Assertions.assertThat(roundResult.results()).isEqualTo(cars.getCurrentStatus());
    }
}
