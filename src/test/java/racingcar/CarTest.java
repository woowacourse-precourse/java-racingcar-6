package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.GameRuleNumbers;

public class CarTest {
    @Test
    @DisplayName("랜덤 값이 조건 값 이상일 때 위치 변화")
    void 랜덤_값이_전진_조건_값_이상이면_앞으로_한칸_이동한다() {
        // given
        Car car = new Car("dami");

        assertRandomNumberInRangeTest(() -> {
            // when
            car.moveOrStop();
            // then
            assertThat(car.getPosition()).isEqualTo(1);
        }, GameRuleNumbers.FORWARD_CONDITION);
    }

    @Test
    @DisplayName("랜덤 값이 조건 값 미만일 때 위치 변화")
    void 랜덤_값이_전진_조건_값_미만이면_정지한다() {
        // given
        Car car = new Car("dami");

        assertRandomNumberInRangeTest(() -> {
            // when
            car.moveOrStop();
            // then
            assertThat(car.getPosition()).isEqualTo(0);
        }, GameRuleNumbers.FORWARD_CONDITION - 1);
    }

}
