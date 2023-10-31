package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RepeatInputProcessTest {
    private RepeatInputProcess repeatInputProcess;

    @BeforeEach
    void setUp() {
        repeatInputProcess = new RepeatInputProcess();
    }

    @Test
    void 자동차의_반복_입력값을_숫자_형식으로_표현() {
        String input = "123";
        int testRepeat = repeatInputProcess.process(input);
        assertThat(testRepeat).isEqualTo(123);
    }

    @Test
    void 자동차의_반복_입력값이_숫자_형식으로_표현되지_않을_때의_예외_처리() {
        String input = "Java";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> repeatInputProcess.process(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
