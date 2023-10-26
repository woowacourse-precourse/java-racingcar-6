package racingcar.request;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static racingcar.constants.ErrorConstants.*;


class RequestCheckerTest {

    @AfterEach
    public void tearDown() {
        Console.close();
    }

    @Test
    @DisplayName("쉼표(,)를 기준으로 자동차 이름을 저장할 수 있다.")
    public void requestNames() {
        // given
        String request = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(request.getBytes()));
        // when
        String[] names = RequestChecker.requestNames();
        // then
        assertThat(names).hasSize(3)
                .contains("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("시도할 횟수를 입력받을 수 있다.")
    public void getNumberOfMovementAttempts() {
        // given
        String request = "5";
        System.setIn(new ByteArrayInputStream(request.getBytes()));
        // when
        int movementAttempts = RequestChecker.getNumberOfMovementAttempts();
        // then
        assertThat(5).isEqualTo(movementAttempts);
    }

    @Test
    @DisplayName("입력이 숫자가 아니면 예외가 발생한다.")
    public void getNumberOfMovementAttemptsException() {
        // given
        String request = "haen";
        System.setIn(new ByteArrayInputStream(request.getBytes()));
        // when // then
        assertThatThrownBy(() -> RequestChecker.getNumberOfMovementAttempts())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIGIT_ERROR_MESSAGE);
    }

}