package racingcar.utils.reader;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingcar.CaptureBaseTest;

class ConsoleReaderTest {

    public static final String INPUT_CONTEXT = "test";
    public static final String NEXT_LINE = "\n";
    CaptureBaseTest consoleCapture;

    @Test
    void 콘솔_입력_테스트() {
        // given
        String inputString = INPUT_CONTEXT;
        Reader reader = new ConsoleReader();
        command(inputString);

        // when
        String read = reader.read();

        // then
        assertThat(read).isEqualTo(inputString);

    }
    private void command(final String... args) {
        final byte[] buf = String.join(NEXT_LINE, args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}