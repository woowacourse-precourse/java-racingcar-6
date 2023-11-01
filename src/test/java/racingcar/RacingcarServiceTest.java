package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;
import racingcar.Service.RacingcarService;

public class RacingcarServiceTest {
    private final RacingcarService racingcarService = new RacingcarService();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private List<Car> carList;

    @BeforeEach
    void setCarList() {
        carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("woni"));
        carList.add(new Car("jun"));
    }

    @Test
    void 자동차_상태_업데이트() {
        Car car = carList.get(0);
        int movedCount = car.getMovedCount();
        String movedStatus = car.getMovedStatus();

        racingcarService.updateCarStatus(car);
        assertThat(car.getMovedCount()).isEqualTo(movedCount + 1);
        assertThat(car.getMovedStatus()).isEqualTo(movedStatus + "-");
    }

    @Test
    void 자동차_이동() {
        assertRandomNumberInRangeTest(
                () -> {
                    String result = racingcarService.move(carList);
                    assertThat(result).isEqualTo("pobi : -\n"
                            + "woni : \n"
                            + "jun : \n");
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

}
