package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.NoCarException;
import racingcar.util.MoveResolver;

class CarsTest {
    private final int MOVING_DISTANCE = 1;

    MoveResolver moveResolver = mock(MoveResolver.class);
    MoveResolver nonMoveResolver = mock(MoveResolver.class);

    Car car1;
    Car car2;
    Car car3;
    Cars cars;

    @BeforeEach
    void setEnvionment() {
        car1 = new Car("테스트1");
        car2 = new Car("테스트2");
        car3 = new Car("테스트3");
        cars = new Cars(List.of(car1,car2,car3));
        setGivenBehaviorMoveResolver(moveResolver,nonMoveResolver);
    }

    @Test
    void 가장_먼_거리를_이동한_자동차를_기준으로_우승한_자동차들의_이름을_구할_수_있다_우승자가_하나일때() {
        stop(car1);
        stop(car2);
        goForward(car3);

        List<String> winners = cars.getWinnerCars();
        assertThat(winners).containsOnly(car3.getName());
    }

    @Test
    void 가장_먼_거리를_이동한_자동차를_기준으로_우승한_자동차들의_이름을_구할_수_있다_우승자가_둘이상일때() {
        stop(car1);
        goForward(car2);
        goForward(car3);

        List<String> winners = cars.getWinnerCars();
        assertThat(winners).containsOnly(car2.getName(),car3.getName());
    }

    @Test
    void 자동차를_등록하지_않은_상태에서_우승자를_찾을수_없다() {
        //given
        cars = new Cars(List.of());

        assertThatThrownBy(() -> cars.getWinnerCars())
                .isInstanceOf(NoCarException.class)
                .hasMessage("등록된 자동차가 없습니다.");
    }

    private void setGivenBehaviorMoveResolver(MoveResolver moveResolver,MoveResolver nonMoveResolver) {
        given(moveResolver.isMoveAble()).willReturn(true);
        given(nonMoveResolver.isMoveAble()).willReturn(false);
    }

    private void goForward(Car car) {
        car.move(MOVING_DISTANCE,moveResolver);
    }

    private void stop(Car car) {
        car.move(MOVING_DISTANCE,nonMoveResolver);
    }
}