package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @DisplayName("자동차를 생성하면 첫 위치는 0이어야 한다.")
    @Test
    void 자동차_초기_생성_테스트() {
        //given
        Car car = new Car("test");

        //when
        String name = car.getName();
        int position = car.getPosition();

        //then
        assertThat(name).isEqualTo("test");
        assertThat(position).isEqualTo(0);
    }
}
