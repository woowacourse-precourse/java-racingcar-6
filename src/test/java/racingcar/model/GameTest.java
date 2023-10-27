package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.MoveResolver;

class GameTest {
    MoveResolver moveResolver = mock(MoveResolver.class);
    MoveResolver nonMoveResolver = mock(MoveResolver.class);
    private final int MOVING_DISTANCE = 1;

    @Test
    void 가장_먼_거리를_이동한_자동차를_기준으로_우승한_자동차들을_구할_수_있다_단일_우승자() {
        setGivenBehaviorMoveResolver(moveResolver,nonMoveResolver);

        List<Car> cars = List.of(new Car("테스트"), new Car("테스트1"), new Car("테스트2"));
        Game game = new Game(cars);

        cars.get(0).move(MOVING_DISTANCE,nonMoveResolver);
        cars.get(0).move(MOVING_DISTANCE,nonMoveResolver);
        cars.get(1).move(MOVING_DISTANCE,nonMoveResolver);
        cars.get(1).move(MOVING_DISTANCE,moveResolver);
        cars.get(2).move(MOVING_DISTANCE,moveResolver);
        cars.get(2).move(MOVING_DISTANCE,moveResolver);

        List<Car> winners = game.getWinnerCars();
        assertThat(winners).extracting(Car::getName).containsOnly("테스트2");
    }

    @Test
    void 가장_먼_거리를_이동한_자동차를_기준으로_우승한_자동차들을_구할_수_있다_복수_우승자() {
        setGivenBehaviorMoveResolver(moveResolver,nonMoveResolver);

        List<Car> cars = List.of(new Car("테스트"), new Car("테스트1"), new Car("테스트2"));
        Game game = new Game(cars);

        cars.get(0).move(MOVING_DISTANCE,nonMoveResolver);
        cars.get(0).move(MOVING_DISTANCE,nonMoveResolver);
        cars.get(1).move(MOVING_DISTANCE,moveResolver);
        cars.get(1).move(MOVING_DISTANCE,moveResolver);
        cars.get(2).move(MOVING_DISTANCE,moveResolver);
        cars.get(2).move(MOVING_DISTANCE,moveResolver);

        List<Car> winners = game.getWinnerCars();
        assertThat(winners).extracting(Car::getName).contains("테스트2","테스트1");
    }

    private void setGivenBehaviorMoveResolver(MoveResolver moveResolver,MoveResolver nonMoveResolver) {
        given(moveResolver.isMoveAble()).willReturn(true);
        given(nonMoveResolver.isMoveAble()).willReturn(false);
    }
}