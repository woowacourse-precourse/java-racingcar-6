package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Cars cars;

    @BeforeEach
    void create() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("랜덤 값에 따라 자동차 움직이기")
    public void 자동차_움직이기_테스트() throws Exception {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("pobi : -", "woni :", "jun : -");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        cars.moveCars();
        cars.printMoves();
    }
}
