package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private InputView inputView;

    protected final void run(final String... args) {
        try {
            command(args);
        } finally {
            Console.close();
        }
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @BeforeEach
    void setInputView() {
        inputView = new InputView();
    }

    @Test
    void 자동차이름_입력_후_리스트변환() {
        run("jung,yuju,dong");
        List<String> expect = Arrays.asList("jung", "yuju", "dong");
        List<String> result = inputView.carName();
        assertThat(result).isEqualTo(expect);
    }
}