package racingcar.utils.writer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.CaptureBaseTest;

class ConsoleWriterTest extends CaptureBaseTest {

    public static final String CONTEXT = "test";

    @Test
    void 콘솔_출력_테스트() {
        // given
        Writer writer = new ConsoleWriter();

        // when
        writer.write(CONTEXT);


        // then
        assertThat(output()).contains(CONTEXT);
    }

}