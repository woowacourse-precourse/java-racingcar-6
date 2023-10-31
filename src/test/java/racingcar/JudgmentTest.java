package racingcar;

import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgmentTest {

    HashMap<String, Integer> cars;
    Judgment judgment;

    @BeforeEach
    void beforeEach() {
        init();
    }

    void init() {
        cars = new HashMap<>();
        cars.put("pobi", 0);
        cars.put("woni", 3);
        judgment = new Judgment();
    }

    @Test
    @DisplayName("자동차들중 우승 위치의 크기를 알 수 있다.")
    void firstCarPosition() {
        judgment.firstCarPosition(cars);

        Assertions.assertThat(judgment.firstPosition).isEqualTo(3);
    }

    @Test
    @DisplayName("우승 위치의 크기와 같은 자동차들을 알 수 있다.")
    void isWinner() {
        judgment.firstPosition = 3;

        Assertions.assertThat(judgment.isWinner(3))
                .isTrue();

        Assertions.assertThat(judgment.isWinner(2))
                .isFalse();
    }
}