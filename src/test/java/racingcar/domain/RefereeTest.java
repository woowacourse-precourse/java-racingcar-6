package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @DisplayName("우승한 자동차의 수는 가장 많이 전진한 자동차의 수와 같다.")
    @Test
    void judge_Success_IsResultSizeSameAsCarsCount() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.moveForward(5);
        car2.moveForward(5);

        Referee referee = new Referee();

        // when
        List<Car> result = referee.judge(List.of(car1, car2, car3));

        // then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
