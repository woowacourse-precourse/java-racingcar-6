package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OutputViewTest {
    @Test
    void 포지션을_작대기로_변환하여_출력하라 () throws Exception {
        //given
        String name = "pobi";
        int position = 5;
        //when
        OutputView outputView = new OutputView();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputView.printCarResult(name, position);
        String outputMessage = outputStream.toString();
        //then
        assertThat(outputMessage).contains("pobi : -----");
    }

}
