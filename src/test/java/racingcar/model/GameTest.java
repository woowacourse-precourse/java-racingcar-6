package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.MoveResolver;

class GameTest {
    private final int MOVING_DISTANCE = 1;

    MoveResolver moveResolver = mock(MoveResolver.class);
    MoveResolver nonMoveResolver = mock(MoveResolver.class);

    Game game;
    List<Car> cars;

    @BeforeEach
    void setEnvionment() {
        game = new Game();
        cars = List.of(new Car("테스트"), new Car("테스트1"), new Car("테스트2"));
        cars.forEach(car -> game.addCar(car));
        setGivenBehaviorMoveResolver(moveResolver,nonMoveResolver);
    }

    @Test
    void 가장_먼_거리를_이동한_자동차를_기준으로_우승한_자동차들을_구할_수_있다_우승자가_하나일때() {
        stop(cars.get(0));
        stop(cars.get(1));
        goForward(cars.get(2));

        List<Car> winners = game.getWinnerCars();
        assertThat(winners).containsOnly(cars.get(2));
        assertThatThrownBy(() -> winners.add(new Car("dd"))).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 가장_먼_거리를_이동한_자동차를_기준으로_우승한_자동차들을_구할_수_있다_우승자가_둘이상일때() {
        stop(cars.get(0));
        goForward(cars.get(1));
        goForward(cars.get(2));

        List<Car> winners = game.getWinnerCars();
        assertThat(winners).containsOnly(cars.get(1),cars.get(2));
        assertThatThrownBy(() -> winners.add(new Car("dd"))).isInstanceOf(UnsupportedOperationException.class);
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