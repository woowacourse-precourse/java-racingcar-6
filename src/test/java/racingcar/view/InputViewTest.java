package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

class InputViewTest {
    private static OutputStream outputStream;

    @BeforeEach
    void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        final InputStream inputStream = new ByteArrayInputStream("test".getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void 자동차_이름_입력() throws Exception {
        // given
        final InputView inputView = InputView.getInstance();

        // when
        final String carName = inputView.readCarName();

        // then
        assertThat(outputStream.toString()).hasToString("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        assertThat(carName).hasToString("test");
    }

    @Test
    void 자동차_이동_횟수_입력() throws Exception {
        // given
        final InputView inputView = InputView.getInstance();

        // when
        final String moveCount = inputView.readMoveCount();

        // then
        assertThat(outputStream.toString()).hasToString("시도할 회수는 몇회인가요?\n");
        assertThat(moveCount).hasToString("test");
    }
}
