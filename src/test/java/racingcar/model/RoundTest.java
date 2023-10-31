package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.count.CountRangeException;
import racingcar.exception.count.NoRemainingRoundsException;

class RoundTest {
    private static final String REQUEST_NON_NEGATIVE = "0이상 입력해주세요.";
    private static final String NOT_REMAIN_ROUND_MESSAGE = "진행할 라운드가 남아있지 않습니다.";

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    void 라운드_횟수가_0이하로_입력되면_예외발생(int count) {

        Assertions.assertThatThrownBy(() -> new Round(count))
                .isInstanceOf(CountRangeException.class)
                .hasMessage(REQUEST_NON_NEGATIVE);
    }

    @Test
    void 라운드가_남아있지_않으면_예외_발생() {
        int initialRounds = 5;
        Round round = new Round(initialRounds);

        Assertions.assertThatThrownBy(() -> {
                    for (int i = 0; i <= initialRounds; i++) {
                        round.nextRound();
                    }
                })
                .isInstanceOf(NoRemainingRoundsException.class)
                .hasMessage(NOT_REMAIN_ROUND_MESSAGE);
    }
}