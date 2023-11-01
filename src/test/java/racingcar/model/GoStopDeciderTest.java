package racingcar.model;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.util.GoStopDecider;

public class GoStopDeciderTest {
    @Test
    public void 랜덤값이4이상일때_1만큼_이동_테스트함수() {
        // given
        GoStopDecider goStopDecider = new GoStopDecider();
        Car car = new Car("테스트 자동차 이름");

        // when
        goStopDecider.moveCarOnRandomValue(car);

        // then
        assertThat(car.getDistance()).isNotNull();
    }
}
