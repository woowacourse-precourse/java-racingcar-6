package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;

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
    void 자동차_객체_리스트_추가_테스트(){
        Racing racing = new Racing();
        List<String> carNameList = new ArrayList<>(List.of("robin", "hood", "kyle"));
        List<Car> carList= racing.toCarList(carNameList);

        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).getName()).isEqualTo(carNameList.get(i));
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
