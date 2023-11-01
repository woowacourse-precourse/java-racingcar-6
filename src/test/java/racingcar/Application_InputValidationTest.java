package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.game.TextResourceManager.GAME_STAGE_VIEW_HEADER;
import static racingcar.game.TextResourceManager.GAME_WINNER_VIEW_TAG;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("애플리케이션의 입력 유효성 검증기능을 테스트")
public class Application_InputValidationTest extends MyApplicationTest {

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

    @Test
    void 자동차_이름이_중복되면_프로그램_종료() {
        assertThatProgramExitsWithIllegalArgumentException(() -> {
            run("pobi,woni,pobi", "10");
        });
    }


    void assertThatProgramExitsWithIllegalArgumentException(ThrowingCallable callable) {
        assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(outputs())
                .doesNotContain(GAME_STAGE_VIEW_HEADER)
                .noneMatch(s -> s.contains(GAME_WINNER_VIEW_TAG));
    }

}
