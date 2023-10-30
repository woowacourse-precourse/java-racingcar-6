package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.component.Car;
import racingcar.component.Inputter;
import racingcar.component.Printer;
import racingcar.component.RaceSimulator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Inputter inputter;
    private Printer printer;
    private RaceSimulator simulator;

    @BeforeEach
    void initAll() {
        this.inputter = Inputter.getInputter();
        this.printer = Printer.getPrinter();
        this.simulator = RaceSimulator.getRaceSimulator(this.printer);
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

    @Test
    @DisplayName("입력된 자동차 이름이 올바르게 리스트로 변환되는지에 대한 테스트")
    void 자동차_이름_입력() {
        String input = "wj,pobi,jun,nick";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<String> returns = inputter.getNameInput();
        assertThat(returns)
                .isNotNull()
                .contains("wj")
                .contains("pobi")
                .contains("jun")
                .contains("nick");
    }

    @Test
    @DisplayName("시도할 횟수 입력에 대한 예외 테스트")
    void 시도할_회수_예외_처리() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "two"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("차량 전진 기능 테스트")
    void 차량_전진_테스트() {
        Car car = new Car("wj");
        assertThat(car.getProgress()).isEqualTo("");
        car.go();
        assertThat(car.getProgress()).isEqualTo("-");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
