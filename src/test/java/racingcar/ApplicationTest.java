package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.ListOfCar;
import racingcar.view.Output;
import racingcar.domain.Race;
import racingcar.model.Car;
import java.util.Arrays;

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
                MOVING_FORWARD, STOP);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도횟수에_대한_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,jun", "-3"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 레이스결과_출력에_대한_문자열_처리() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("jun");
        Car car3 = new Car("woni");
        Race.advance(car1);
        Race.advance(car3);
        Race.advance(car3);
        ListOfCar cars = new ListOfCar(Arrays.asList(car1, car2, car3));
        Output.printResult(cars);
        assertThat(output()).contains("pobi : -", "jun :", "woni : --");
    }

    @Test
    void 최종우승자_출력에_대한_문자열_처리() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("jun");
        ListOfCar cars = new ListOfCar(Arrays.asList(car1, car2));
        Output.printWinner(cars);
        assertThat(output()).isEqualTo("최종 우승자 : pobi, jun");
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
