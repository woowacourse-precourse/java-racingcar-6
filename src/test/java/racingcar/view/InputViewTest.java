package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.OutputTestSupport;

import static org.assertj.core.api.Assertions.*;
import static racingcar.constants.MessageConstants.ATTEMPT_COUNT_MESSAGE;
import static racingcar.constants.MessageConstants.START_MESSAGE;

class InputViewTest extends OutputTestSupport {

    @Test
    @DisplayName("시작 메시지를 출력할 수 있다.")
    public void printStartMessage() {
        // given // when
        InputView.printStartMessage();
        // then
        assertThat(outputWithoutTrim()).isEqualTo(START_MESSAGE);
    }

    @Test
    @DisplayName("시도할 횟수를 물어보는 메시지를 출력할 수 있다.")
    public void printAttemptCountMessage() {
        // given // when
        InputView.printAttemptCountMessage();
        // then
        assertThat(outputWithoutTrim()).isEqualTo(ATTEMPT_COUNT_MESSAGE);
    }
}