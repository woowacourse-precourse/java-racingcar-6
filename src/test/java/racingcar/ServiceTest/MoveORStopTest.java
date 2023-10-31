package racingcar.ServiceTest;

import org.junit.jupiter.api.Test;
import racingcar.Service.MoveORStop;
import racingcar.domain.CarList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveORStopTest {

    @Test
    void 랜덤_숫자_범위_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> MoveORStop.validateRandomNumberRange(10))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전진_테스트() {
        CarList carList = new CarList("레이싱카");
        carList.moving(6);
        assertThat(carList.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지_테스트() {
        CarList carList = new CarList("레이싱카");
        carList.moving(3);
        assertThat(carList.getPosition()).isEqualTo(0);
    }
}
