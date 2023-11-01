package study.service;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.Round;
import racingcar.model.Car;

public class GamePlayTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 랜덤값_4이상_전진() {
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        assertRandomNumberInRangeTest(
                () -> {
                    Round.createRandom(carList);
                    assertEquals(0, car1.getPosition());
                    assertEquals(1, car2.getPosition());
                    assertEquals(1, car3.getPosition());
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );

    }
}
