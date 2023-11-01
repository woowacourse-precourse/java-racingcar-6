package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Service.CarService;
import racingcar.Service.RaceService;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final CarService carService = new CarService();
    private static final RaceService raceService = new RaceService();
    private static List<Car> cars;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 자동차_이동(){
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        cars.add(car1);
        cars.add(car2);
        // when
        carService.runOneTurn(cars);
        carService.showResults(cars);

        assertThat(output()).contains("-");
    }

    @Test
    void 아무도_전진하지_않았을_때_최종_우승자_산출(){
        // given
        RaceService raceService = new RaceService();
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        cars.add(car1);
        cars.add(car2);

        // when
        raceService.showResults(cars);

        // then
        assertThat(output()).contains("car1", "car2");
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
