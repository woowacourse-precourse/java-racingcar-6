package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.output.Output;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {
    private Input input;
    private ByteArrayInputStream inputStream;
    private ByteArrayOutputStream outputStream;
    private static final String CAR_NAME_USER_INPUT = "pobi,wooni,jun";
    private static final String ROUND_COUNT_USER_INPUT = "5";
    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_COUNT_PROMPT = "시도할 회수는 몇회인가요?";

    @BeforeEach
    void setUp() {
        input = new Input(new Output());
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }


    @Test
    void reaquestCarNames메소드로_인풋메세지출력과_입력한_메세지가_반환() {
        inputStream = new ByteArrayInputStream(CAR_NAME_USER_INPUT.getBytes());
        System.setIn(inputStream);

        String inputReturn = input.requestCarNames();

        assertThat(inputReturn).isEqualTo(CAR_NAME_USER_INPUT);
        String printedOutput = outputStream.toString().trim();
        assertThat(printedOutput).isEqualTo(CAR_NAMES_PROMPT);
    }

    @Test
    void reaquestRoundCount메소드로_인풋메세지출력과_입력한_메세지가_반환() {
        inputStream = new ByteArrayInputStream(ROUND_COUNT_USER_INPUT.getBytes());
        System.setIn(inputStream);

        String inputReturn = input.requestRoundCount();

        assertThat(inputReturn).isEqualTo(ROUND_COUNT_USER_INPUT);
        String printedOutput = outputStream.toString().trim();
        assertThat(printedOutput).isEqualTo(ROUND_COUNT_PROMPT);
    }
}