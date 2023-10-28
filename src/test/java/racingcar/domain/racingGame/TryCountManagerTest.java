package racingcar.domain.racingGame;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.IOTest;

class TryCountManagerTest extends IOTest {
    @Test
    void 시도_횟수_입력받은후_해당_횟수만큼_람다_호출() {
        //given
        TryCountManager tryCountManager = new TryCountManager();

        //when
        int tryCount = 3;
        String message = "message";
        command(tryCount+"");
        tryCountManager.makeTryCount();
        tryCountManager.invokeForTryCount(() -> System.out.print(message));

        //then
        assertThat(output()).contains("시도할 회수는 몇회인가요?", message.repeat(tryCount));
    }

    @Test
    void 숫자가_아닌_입력을_받으면_예외_발생() {
        //given
        TryCountManager tryCountManager = new TryCountManager();

        //when
        command("3번");

        //then
        assertThatThrownBy(() -> tryCountManager.makeTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }
}