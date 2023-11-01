package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    private String getSystemOutput() {
        return output.toString();
    }

    private InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(System.out);
        output.reset();
    }

    @AfterEach
    public void closeConsole() {
        camp.nextstep.edu.missionutils.Console.close();
    }

    @Test
    void readCarNames_사용자가_입력한_자동차_이름을_문자열로_반환() {
        //given
        System.setIn(createUserInput("dawin,woowa,han"));

        //when
        String carNamesInput = InputView.readCarNames();

        //then
        assertThat(getSystemOutput()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + "\n");
        assertThat(carNamesInput).isEqualTo("dawin,woowa,han");
    }

    @Test
    void readRoundNumber_사용자가_입력한_이동_회수를_문자열로_반환() {
        //given
        System.setIn(createUserInput("15"));

        //when
        String carNamesInput = InputView.readRoundNumber();

        //then
        assertThat(getSystemOutput()).isEqualTo("시도할 회수는 몇회인가요?" + "\n");
        assertThat(carNamesInput).isEqualTo("15");
    }
}