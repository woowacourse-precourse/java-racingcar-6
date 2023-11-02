package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private InputView inputView;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setup() {
        Console.close();
        inputView = new InputView();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @DisplayName("사용자가 자동차 이름들을 입력시 리스트 형태를 반환 받는다. - 성공")
    @Test
    void userCarNamesInputTest() {
        // given
        String input = "a,b,c";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> result = inputView.carNameListInput();

        // then
        assertAll(
            () -> assertThat(result).hasSize(3),
            () -> assertThat(result).containsExactly("a", "b", "c")
        );
    }

    @DisplayName("사용자가 총 시도 횟수를 입력시 정수를 받환 받는다.  - 성공")
    @Test
    void userThreeNumberInputTest() {
        // given
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int result = inputView.totalAttemptsInput();

        // then
        assertThat(result).isEqualTo(3);
    }

}
