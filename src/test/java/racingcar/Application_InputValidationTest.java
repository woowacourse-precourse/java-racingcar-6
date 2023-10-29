package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

public class Application_InputValidationTest extends MyApplicationTest {

    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";

    @Test
    void 자동차_이름을_빈_문자열로_주면_프로그램_종료() {
        assertThatProgramExitsWithIllegalArgumentException(() -> {
            run("", "10");

        });
    }

    @Test
    void 자동차_이름이_0글자이면_프로그램_종료() {
        assertThatProgramExitsWithIllegalArgumentException(() -> {
            run("pobi,,woni", "10");

        });
    }

    @Test
    void 자동차_이름이_6글자_이상이면_프로그램_종료() {
        assertThatProgramExitsWithIllegalArgumentException(() -> {
            run("pobi,sebastian,woni", "10");

        });
    }

    @Test
    void 시도할_횟수가_0_이하의_값이면_프로그램_종료() {
        assertThatProgramExitsWithIllegalArgumentException(() -> {
            run("pobi,woni", "-15");

        });
    }


    void assertThatProgramExitsWithIllegalArgumentException(ThrowingCallable callable) {
        assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(outputs())
                .doesNotContain(EXECUTION_RESULT)
                .noneMatch(s -> s.contains(FINAL_WINNER));
    }

}
