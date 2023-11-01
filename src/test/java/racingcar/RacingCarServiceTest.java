package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;

public class RacingCarServiceTest extends NsTest {
    @Test
    void 자동차_이름_제대로_n개_입력시_참가하는_자동차_리스트_크기_n인지_확인() {
        RacingCarService racingCarService = new RacingCarService();
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        List<Car> cars = racingCarService.registerCars(carNames);

        assertEquals(3, cars.size());
    }

    @Test
    void 랜덤_숫자가_4이상일_경우_전진_3이하일_경우_정지() {
        int FORWARD = 4;
        int STOP = 3;
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b", "3");
                    assertThat(output()).contains("a : ---", "b : -", "최종 우승자 : a");
                },
                FORWARD, STOP, FORWARD, STOP, FORWARD, FORWARD
        );
    }

    @Test
    void 단독_우승자_확인() {
        List<Car> carList = Arrays.asList(new Car("a", 3),
                new Car("b", 2),
                new Car("c", 1));
        RacingCarService racingCarService = new RacingCarService();

        RacingCarService.carList = carList;
        String winners = racingCarService.findWinners();
        assertThat(winners).isEqualTo("최종 우승자 : a", winners);
    }

    @Test
    void 공동_우승자_확인() {
        List<Car> carList = Arrays.asList(new Car("a", 3),
                new Car("b", 3),
                new Car("c", 2));
        RacingCarService racingCarService = new RacingCarService();

        RacingCarService.carList = carList;
        String winners = racingCarService.findWinners();
        assertThat(winners).isEqualTo("최종 우승자 : a, b", winners);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
