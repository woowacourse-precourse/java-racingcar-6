package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private final Car car1 = new Car("car1");
    private final Car car2 = new Car("car2");
    private final Car car3 = new Car("car3");
    private final Cars cars = new Cars(Arrays.asList(car1, car2, car3));

    @Test
    @DisplayName("자동차의 이름과 위치를 맵으로 반환하는지 테스트")
    void testGetRoundInfo() {
        Map<String, Integer> roundInfo = cars.getRoundInfo();
        assertThat(roundInfo.get("car1")).isEqualTo(0);
        assertThat(roundInfo.get("car2")).isEqualTo(0);
        assertThat(roundInfo.get("car3")).isEqualTo(0);
    }

    @Test
    @DisplayName("위치가 가장 먼 자동차를 반환하는지 테스트")
    void testGetWinners() {
        car1.attemptToMove();
        car1.attemptToMove();
        List<Car> winners = cars.getWinners();
        assertThat(winners).contains(car1);
        assertThat(winners).doesNotContain(car2, car3);
    }

}
