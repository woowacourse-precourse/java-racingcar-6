package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.util.MoveResolver;

class CarTest {

    MoveResolver moveResolver = Mockito.mock(MoveResolver.class);

    private final int MOVING_DISTANCE = 1;

    @Test
    void 자동차를_생성자_이름_Null() {
        assertThatThrownBy(() -> new Car(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void 자동차는_조건에_부합하면_움직인다() {
        given(moveResolver.isMoveAble()).willReturn(true);
        Car car = new Car("테스트");
        int currentPosition = car.getPosition();

        car.move(MOVING_DISTANCE, moveResolver);

        assertThat(car.getPosition() - currentPosition).isEqualTo(MOVING_DISTANCE);
    }

    @Test
    void 자동차는_조건에_부합하지않으면_움직이지_않는다() {
        given(moveResolver.isMoveAble()).willReturn(false);
        Car car = new Car("테스트");
        int currentPosition = car.getPosition();

        car.move(MOVING_DISTANCE, moveResolver);

        assertThat(car.getPosition() - currentPosition).isEqualTo(0);
    }
}