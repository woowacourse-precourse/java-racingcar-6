package racingcar.domain.racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.IOTest;
import racingcar.domain.racinggame.trycountfactory.InputTryCountFactory;
import racingcar.domain.racinggame.trycountfactory.TryCountFactory;
import racingcar.domain.racinggame.validator.TryCountValidator;

class TryCountManagerTest extends IOTest {
    @Test
    void 시도_횟수_입력받은후_해당_횟수만큼_람다_호출() {
        //given
        TryCountManager tryCountManager = new TryCountManager(new InputTryCountFactory(new TryCountValidator()));

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
        TryCountManager tryCountManager = new TryCountManager(new InputTryCountFactory(new TryCountValidator()));

        //when
        command("3번");

        //then
        assertThatThrownBy(() -> tryCountManager.makeTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @Test
    void 최대_시도횟수를_넘으면_예외_발생() {
        //given
        TryCountManager tryCountManager = new TryCountManager(new InputTryCountFactory(new TryCountValidator()));
        int tryCount = TryCountFactory.MAX_TRY_COUNT + 1;

        //when
        command(tryCount + "");

        //then
        assertThatThrownBy(() -> tryCountManager.makeTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 최대 " + TryCountFactory.MAX_TRY_COUNT + "번 가능합니다.");
    }
}