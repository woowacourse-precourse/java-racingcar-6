package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Round;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Application.askRound;

public class RoundTest {
    void setInputStream(String carNames) {
        System.setIn(new ByteArrayInputStream(carNames.getBytes()));
    }

    @AfterEach
    void closeInputStream() {
        close();
    }

    @Test
    void 정상_테스트_시도_횟수_입력() {
        // given
        setInputStream("1");

        // when
        Round round = new Round(askRound());

        // then
        assertThat(round.getRound()).isEqualTo(1);
    }

    @Test
    void 예외_테스트_범위_밖_작은_시도_횟수() {
        // given
        setInputStream("0");

        // when, then
        assertThatThrownBy(() -> new Round(askRound()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_범위_밖_작은_시도_횟수_2() {
        // given
        setInputStream("-10");

        // when, then
        assertThatThrownBy(() -> new Round(askRound()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_범위_밖_큰_시도_횟수() {
        // given
        setInputStream("1000");

        // when, then
        assertThatThrownBy(() -> new Round(askRound()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_문자_입력() {
        // given
        setInputStream("hi");

        // when, then
        assertThatThrownBy(() -> new Round(askRound()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
