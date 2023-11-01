package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static racingcar.constants.CarRandomCondition.MOVING_FORWARD;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import racingcar.PrintOutputTest;
import racingcar.model.Car;
import racingcar.model.CarModel;
import racingcar.util.style.DistanceStyleFactory;
import racingcar.util.style.DistanceStyles;
import racingcar.view.car.CarView;
import racingcar.view.output.ConsoleOutputView;

public class CarViewTest extends PrintOutputTest {

    @Test
    @DisplayName("출력 시 자동차 이름을 같이 출력한다.")
    void 모델이_업데이트_되는경우_Car_이름과_거리출력() {
        final CarModel car = new Car("jun");
        final CarView carView = new CarView(car, new ConsoleOutputView(),
                DistanceStyleFactory.create(DistanceStyles.DASH));

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(MOVING_FORWARD);
            car.moveForward();
            assertThat(output()).contains("jun : -");
        }
    }
}
