package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewImplTest {

    InputView inputView = new InputViewImpl(new ValidateImpl());

    @AfterEach
    void before() {
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void 차량의_이름들을_입력받는다() {
        // given
        ByteArrayInputStream input = new ByteArrayInputStream("pobi,woni,jun".getBytes());
        List<String> expected = List.of("pobi", "woni", "jun");
        System.setIn(input);

        // when
        List<String> carNames = inputView.inputCarNames();

        // then
        assertThat(carNames).isEqualTo(expected);
    }

    @Test
    void 시도할_횟수를_입력받는다() {
        // given
        ByteArrayInputStream input = new ByteArrayInputStream("4".getBytes());
        int expected = 4;
        System.setIn(input);

        // when
        int retryCount = inputView.inputRetryCount();

        // then
        assertThat(retryCount).isEqualTo(expected);
    }
}