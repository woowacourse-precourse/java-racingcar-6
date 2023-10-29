package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("자동차 이름 입력받기")
    void 차이름_입력() {
        // given
        systemIn("aa,bb");

        // when
        List<String> carNameList = inputView.enterCarNames();

        // then
        assertThat(out.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        assertThat(carNameList).contains("aa","bb");
    }

    @Test
    @DisplayName("시도 횟수 입력받기")
    void 시도_횟수_입력() {
        // given
        systemIn("5");

        // when
        Integer rotateNumber = inputView.enterRotateNumber();

        // then
        assertThat(out.toString()).contains("시도할 회수는 몇회인가요?");
        assertThat(rotateNumber).isEqualTo(5);
    }

    @Test
    @DisplayName("반복 횟수가 숫자로 입력되어야 한다.")
    void 횟수_입력_예외() {
        // given
        InputViewTest.systemIn("a,b,c\nG");

        // when
        // then
        assertThatThrownBy(() -> inputView.enterRotateNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static void systemIn(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}
