package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
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
    void 자동차_객체_전진_증가_테스트(){
        Car car = new Car("robin");
        Car car2 = new Car("nope");
        assertSimpleTest(() -> {
            assertThat(car.getForwardNum()).isEqualTo(0);
            car.increaseForwardNum();
            car2.increaseForwardNum();
            assertThat(car.getForwardNum()).isEqualTo(1);
        });

    }

    @Test
    void 경주_출력_확인_테스트1(){
        OutputView outputView = new OutputView();
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("coni");
        car1.increaseForwardNum();
        car1.increaseForwardNum();
        List<Car> carList = new ArrayList<>(List.of(car1, car2, car3));

        assertRandomNumberInRangeTest(
                () -> {
                    outputView.printRacingResult(carList);
                    assertThat(output()).contains("pobi : --", "woni : ", "coni :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 경주_출력_확인_테스트2(){
        OutputView outputView = new OutputView();
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car2.increaseForwardNum();
        car2.increaseForwardNum();
        List<Car> carList = new ArrayList<>(List.of(car1, car2));

        assertRandomNumberInRangeTest(
                () -> {
                    outputView.printRacingResult(carList);
                    assertThat(output()).contains("pobi : ", "woni : --");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
