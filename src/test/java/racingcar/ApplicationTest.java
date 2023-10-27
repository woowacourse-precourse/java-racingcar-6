package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.vo.CarName;

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

    @DisplayName("자동차가 저장되는지 확인")
    @Test
    void 자동차가_저장되는지_확인() {
        CarRepository carRepository = CarRepository.getInstance();
        Car car1 = new Car(new CarName("test1"));
        Car car2 = new Car(new CarName("test2"));

        carRepository.save(car1);

        List<Car> carList = carRepository.findAll();


        Assertions.assertThat(carList).contains(car1);

        Assertions.assertThat(carList).contains(car2);

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
