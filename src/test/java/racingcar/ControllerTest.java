package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;
import racingcar.model.Car;

public class ControllerTest {
    private CarController carController = new CarController();
    private final int FORWARD = 4, STOP = 3;

    @Test
    void 자동차_이름으로_자동차_생성() {
        List<String> names = List.of("pobi", "woni", "jun");
        List<Car> result = carController.createCars(names);

        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void 무작위값_체크() {
        Car forward = new Car("forward");
        Car stop = new Car("stop");
        assertRandomNumberInRangeTest(() -> {
            carController.race(forward);
            assertThat(forward.toString()).isEqualTo("forward : -");
            carController.race(stop);
            assertThat(stop.toString()).isEqualTo("stop : ");
        }, FORWARD, STOP);
    }
}
