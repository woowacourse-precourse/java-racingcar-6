package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarInputProcess;
import racingcar.domain.RepeatInputProcess;

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
    void 자동차_이름을_쉼표로_구분() {
        CarInputProcess carInputProcess = new CarInputProcess();
        String input = "java,unity";
        List<String> testCars = carInputProcess.process(input);
        assertThat(testCars).contains("java", "unity");
        assertThat(testCars).containsExactly("java", "unity");
    }

    @Test
    void 자동차의_반복_입력값을_숫자_형식으로_표현() {
        RepeatInputProcess repeatInputProcess = new RepeatInputProcess();
        String input = "123";
        int testRepeat = repeatInputProcess.process(input);
        assertThat(testRepeat).isEqualTo(123);
    }

    @Test
    void 자동차의_반복_입력값이_숫자_형식으로_표현되지_않을_때의_예외_처리() {
        RepeatInputProcess repeatInputProcess = new RepeatInputProcess();
        String input = "Java";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> repeatInputProcess.process(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
