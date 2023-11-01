package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.GameService;

public class GameServiceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }


    @Test
    void 자동차_객체_생성() {
        // given
        List<Car> cars = new ArrayList<>();
        List<String> carNames = List.of("pobi", "jun", "ker");

        // when
        gameService.setCars(carNames, cars);

        // then
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 우승자_판단() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("jun");
        Car car3 = new Car("ker");
        List<Car> cars = List.of(car1, car2, car3);
        assertRandomNumberInRangeTest(
                () -> {
                    car1.move();
                    car2.move();
                    car3.move();
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );

        //when
        List<Car> winners = gameService.getWinners(cars);

        //then
        assertThat(winners)
                .extracting(Car::getName)
                .contains("pobi", "ker");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
