package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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

    @Test
    public void 차_여러대_생성() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        List<Car> cars = Application.createCars(carNames);

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }

    @Test
    public void 차_한대_결과() {
        Car car = new Car("test");
        car.move(4);

        String result = Application.getCarResult(car);

        assertThat(result).isEqualTo("test : -\n");
    }

    @Test
    public void 여러대의_차_결과() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("car1");
        car1.move(4);
        cars.add(car1);

        Car car2 = new Car("car2");
        car2.move(3);
        cars.add(car2);

        String result = Application.printRaceResult(cars);

        assertThat(result).isEqualTo("car1 : -\n" + "car2 : \n");
    }
    @Test
    public void 공동우승_결과() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(4);
        car2.move(4);
        car3.move(2);

        List<Car> cars = Arrays.asList(car1, car2, car3);

        String winners = Application.printWinners(cars);

        assertThat(winners).isEqualTo("최종 우승자 : car1, car2");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
