package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    InputView inputView = new InputView();

    @AfterEach
    void close() {
        Console.close();
    }

    @Test
    void 차이름_입력() {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String input = "aa,bb";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        inputView.enterCarNames();

        // then
        assertThat(out.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 시도_횟수_입력() {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String input = "5";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        inputView.enterRotateNumber();

        // then
        assertThat(out.toString()).contains("시도할 회수는 몇회인가요?");
    }
}
