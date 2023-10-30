package racingcar;

import model.CarName;
import model.CarPosition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarPositionTest {
    @Test
    @DisplayName("자동차 위치 생성 테스트")
    void 자동차_위치_생성() {
        CarPosition pos = new CarPosition();
        Assertions.assertThat(pos).isNotNull();
    }

    @Test
    @DisplayName("자동차 초기 위치 테스트")
    void 자동차_초기위치_테스트(){
        CarPosition pos = new CarPosition();
        Assertions.assertThat(pos.toInt()).isEqualTo(0);
    }
}
