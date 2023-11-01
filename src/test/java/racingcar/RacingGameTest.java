package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static racingcar.Constant.DISTANCE;
import static racingcar.Constant.FINAL_WINNER_MESSAGE;
import static racingcar.Constant.PRINT_DISTANCE_SEPARATOR;
import static racingcar.Constant.RESULT_JOIN_SEPARATOR;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class RacingGameTest {
    private List<Car> cars;
    private RacingGame racingGame;
    OutputView outputView;

    @BeforeEach
    void 기본_설정_셋팅() {
        cars = new ArrayList<>();
        cars.add(new Car("Car1"));
        cars.add(new Car("Car2"));
        outputView = mock(OutputView.class);
        racingGame = new RacingGame(cars, 1, outputView);
    }

    @Test
    void 랜덤값이_4_이상이면_전진() {
        Car car = new Car("Car1");
        try (MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            mocked.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(8);

            car.moveForward();

            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    @Test
    void 랜덤값이_4_미만이면_멈춤() {
        Car car = new Car("Car1");
        try (MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            mocked.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(2);

            assertThat(car.getDistance()).isEqualTo(0);
        }
    }

    @Test
    void 전진한_거리를_출력() {
        cars.get(0).moveForward(); // Car1 전진

        racingGame.printResult();

        verify(outputView).print(cars.get(0).getName());
        verify(outputView, times(2)).print(PRINT_DISTANCE_SEPARATOR);
        verify(outputView).print(DISTANCE.repeat(cars.get(0).getDistance()));
        verify(outputView).print(cars.get(1).getName());
        verify(outputView).print(DISTANCE.repeat(cars.get(1).getDistance()));
        verify(outputView, times(3)).lineBreak();
    }

    @Test
    void 우승자가_한_대일때_출력() {
        cars.get(0).moveForward(); // Car1 전진

        racingGame.printWinner();

        verify(outputView).print(FINAL_WINNER_MESSAGE);
        verify(outputView).print(cars.get(0).getName());
    }

    @Test
    void 우승자가_여러_대일때_출력() {
        cars.get(0).moveForward(); // Car1 전진
        cars.get(1).moveForward(); // Car2 전진

        racingGame.printWinner();

        verify(outputView).print(FINAL_WINNER_MESSAGE);
        verify(outputView).print(cars.get(0).getName() + RESULT_JOIN_SEPARATOR + cars.get(1).getName());
    }
}
