package racingcar.viewTest;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;



public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        Console.close();
    }

    @Test
    void getCarNames_입력값이_유효한경우() {
        String input = "car1,car2,car3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String[] carNames = inputView.getCarNames();

        assertArrayEquals(new String[]{"car1", "car2", "car3"}, carNames);
    }

    @Test
    void getCarNames_이름이_5자_보다큰경우_예외발생() {
        String input = "car123,car2,car3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.getCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름이 5자 보다 큽니다.");
    }

    @Test
    void getNumberOfAttempts_유효한_숫자를_입력한경우() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int attempts = inputView.getNumberOfAttempts();

        assertThat(attempts).isEqualTo(5);
    }

    @Test
    void getNumberOfAttempts_잘못된_입력값을_입력한경우_예외발생() {
        String input = "invalidInput";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.getNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력하세요. 잘못된 입력값입니다.");
    }
}
