package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    Winners winners;
    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of(new Car("pobi", 5), new Car("crong", 5), new Car("pororo", 1)));
        winners = new Winners(cars);
    }

    @Test
    void 최대_이동거리_판별_기능() {
        assertThat(winners.getMaxDistance(cars)).isEqualTo(5);
    }

    @Test
    void 최종_우승자_판별_기능() {
        assertThat(winners.getFinalWinnerNames()).containsExactly("pobi", "crong");
    }
}
