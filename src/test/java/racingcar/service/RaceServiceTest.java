package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class RaceServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private RaceService raceService = new RaceService();

    @Test
    void 랜덤_번호_가져오기() {
        assertRandomNumberInRangeTest(
                () -> {
                    int movingNumber = Randoms.pickNumberInRange(0, 9);
                    int stopNumber = Randoms.pickNumberInRange(0, 9);
                    assertThat(movingNumber).isEqualTo(4);
                    assertThat(stopNumber).isEqualTo(3);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차_레이스_한번() {
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("java")
        );

        assertRandomNumberInRangeTest(
                () -> {
                    raceService.runRace(cars);
                    Car pobi = cars.get(0);
                    Car woni = cars.get(1);
                    Car java = cars.get(2);
                    assertThat(pobi.getLocation()).isEqualTo(1);
                    assertThat(woni.getLocation()).isEqualTo(1);
                    assertThat(java.getLocation()).isEqualTo(0);
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }
}
