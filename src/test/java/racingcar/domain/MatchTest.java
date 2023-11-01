package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MatchTest {

    @Test
    @DisplayName("자동차 이름으로 경기객체를 생성하면 자동차 객체가 생성된다.")
    void createMatch() {
        // given
        List<String> carNames = List.of("test1", "test2");
        Match match = new Match(carNames);

        // when
        List<Car> actual = match.getCars();

        // then
        List<Car> expected = List.of(new Car("test1", 0), new Car("test2", 0));
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

}