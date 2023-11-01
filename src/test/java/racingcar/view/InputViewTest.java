package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

    private InputView inputView;
    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @BeforeEach
    void setMockInputOutput() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        inputView = new InputView();
    }

    @AfterEach
    void setSystemInputOutput() {
        System.setOut(System.out);
        Console.close();
    }

    @Test
    void 자동차_이름_입력_출력() {
        String inputString = "matia,maria";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
        inputView.readNames();

        assertThat(outputStream.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 자동차_경주_회수_입력_출력() {
        String inputString = "10";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        inputView.readNumberOfRaces();

        assertThat(outputStream.toString()).contains("시도할 회수는 몇회인가요?");
    }

    @Test
    void 자동차_이름_입력() {
        String inputString = "matia,maria";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        var carNames = inputView.readNames();

        assertEquals(List.of("matia", "maria"), carNames);
    }

    @Test
    void 자동차_경주_회수_입력() {
        String inputString = "10";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        int numberOfRaces = inputView.readNumberOfRaces();

        assertEquals(10, numberOfRaces);
    }
}
