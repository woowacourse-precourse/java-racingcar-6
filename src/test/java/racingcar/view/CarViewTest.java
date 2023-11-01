package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static racingcar.constants.CarRandomCondition.MOVING_FORWARD;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.PrintOutputTest;
import racingcar.model.Car;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.style.DistanceStyleFactory;
import racingcar.util.style.DistanceStyles;
import racingcar.view.car.CarView;
import racingcar.view.output.ConsoleOutputView;

public class CarViewTest extends PrintOutputTest {

    @Test
    @DisplayName("출력 시 자동차 이름을 같이 출력한다.")
    void 모델이_업데이트_되는경우_Car_이름과_거리출력() {
        final RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);
        when(mockGenerator.generate()).thenReturn(MOVING_FORWARD);

        final Car car = new Car("jun");
        car.setNumberGenerator(mockGenerator);
        final CarView carView = new CarView(car, new ConsoleOutputView(),
                DistanceStyleFactory.create(DistanceStyles.DASH));

        car.moveForward();
        assertThat(output()).contains("jun : -");
    }
}
