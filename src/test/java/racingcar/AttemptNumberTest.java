package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Application.askAttemptNumber;

public class AttemptNumberTest {
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
        Integer attemptNumber = askAttemptNumber();

        // then
        assertThat(attemptNumber).isEqualTo(1);
    }

    @Test
    void 예외_테스트_범위_밖_작은_시도_횟수() {
        // given
        setInputStream("0");

        // when, then
        assertThatThrownBy(Application::askAttemptNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_범위_밖_작은_시도_횟수_2() {
        // given
        setInputStream("-10");

        // when, then
        assertThatThrownBy(Application::askAttemptNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_범위_밖_큰_시도_횟수() {
        // given
        setInputStream("1000");

        // when, then
        assertThatThrownBy(Application::askAttemptNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
