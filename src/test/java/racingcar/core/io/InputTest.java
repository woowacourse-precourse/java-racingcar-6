package racingcar.core.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.core.NamesParser;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    private final Validator validator;
    private final NamesParser parser;
    private final Input input;

    public InputTest(final Validator validator, final NamesParser parser) {
        this.validator = new Validator();
        this.parser = new NamesParser();
        this.input = new Input(validator, parser);
    }

    @Test
    @DisplayName("정상값을 입력한 경우")
    void 정상값을_입력한_경우() throws Exception {
        String userInput = "car1,car2,car3";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //given

        //when

        //then
    }
}