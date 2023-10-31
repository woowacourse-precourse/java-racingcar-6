package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.NOT_POSITIVE_INTEGER;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    InputView inputView = new InputView();
    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void open() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void close() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름 ','로 구분하여 입력받기")
    void 자동차_이름_입력() {
        // given
        systemIn("aa,bb");

        // when
        List<String> carNameList = inputView.enterCarNames();

        // then
        assertThat(out.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        assertThat(carNameList).containsExactly("aa", "bb");
        assertThat(carNameList).hasSize(2);
    }


    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "100", "1000", "10000", "99999"})
    @DisplayName("시도 횟수 입력받기")
    void 시도_횟수_입력(String input) {
        // given
        systemIn(input);

        // when
        Integer rotateNumber = inputView.enterRotateNumber();

        // then
        assertThat(out.toString()).contains("시도할 회수는 몇회인가요?");
        assertThat(rotateNumber).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "-1", "-10", "A", "A1", "1A", "1A1", "A1A"})
    @DisplayName("반복 횟수가 0 또는 양의 정수로 입력되어야 한다.")
    void 횟수_입력_예외(String input) {
        // given
        InputViewTest.systemIn(input);

        // when
        // then
        assertThatThrownBy(() -> inputView.enterRotateNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_POSITIVE_INTEGER.getMessage());
    }

    public static void systemIn(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}
