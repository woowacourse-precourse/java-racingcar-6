package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarFactory;

public class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 차_생성_테스트() {
        String testCarName = "찬";
        List<Car> cars = CarFactory.createCar(testCarName);

        assertThat(cars).hasSize(1);
        assertThat(cars.get(0).getName()).isEqualTo(testCarName);
    }

    @Test
    void 복수의_차_생성_테스트() {
        List<String> carNames = Arrays.asList("java", "tech", "study");

        String testCarNames = String.join(",", carNames);
        List<Car> cars = CarFactory.createCar(testCarNames);

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo(carNames.get(0));
        assertThat(cars.get(1).getName()).isEqualTo(carNames.get(1));
        assertThat(cars.get(2).getName()).isEqualTo(carNames.get(2));
    }

    @Test
    void 공백이_포함된_차_이름_입력값_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("우 아", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 특수문자가_포함된_차_이름_입력값_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("차!", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차_이름을_입력하지_않은_입력값_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 숫자가_아닌_이동_횟수_입력값_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("chan", "a"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 음수인_이동_횟수__입력값_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("chan", "-1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 우승자가_여럿인_경우_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,chan", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "chan : -", "최종 우승자 : pobi, chan");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
