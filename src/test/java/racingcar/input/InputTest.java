package racingcar.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.output.Output;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {
    private Input input;
    private InputStream inputStream;
    private OutputStream outputStream;
    private ByteArrayInputStream byteArrayInputStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    private static final String USER_INPUT_MESSAGE = "테스트 사용자가 입력하는 인풋 메세지입니다.";
    private static final String INPUT_HINT_MESSAGE = "테스트 인풋 안내 메세지입니다.";
    @BeforeEach
    void setUp() {
        input = new Input(new Output());
        inputStream = System.in;
        outputStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void read메소드로_인풋메세지출력과_입력한_메세지가_반환() {
        byteArrayInputStream = new ByteArrayInputStream(USER_INPUT_MESSAGE.getBytes());
        System.setIn(byteArrayInputStream);

        String inputReturn = input.read(INPUT_HINT_MESSAGE);

        assertThat(inputReturn).isEqualTo(USER_INPUT_MESSAGE);
        String printedOutput = byteArrayOutputStream.toString().trim();
        assertThat(printedOutput).isEqualTo(INPUT_HINT_MESSAGE);
    }

}