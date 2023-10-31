package racingcar.domain.racing;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.view.GameView;

public class GameRoundManagerTest {
    private GameRoundManager gameRoundManager;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(mock(Car.class), mock(Car.class), mock(Car.class));
        gameRoundManager = new GameRoundManager(cars, mock(GameView.class));
    }

    @Test
    @DisplayName("한 회차 게임을 진행하면, 모든 자동차의 move 메서드가 호출된다.")
    void playRound_AllCarsMoveMethodCalled() {
        // When
        gameRoundManager.playRound();

        // Then
        for (Car car : cars) {
            verify(car).move();
        }
    }
}
