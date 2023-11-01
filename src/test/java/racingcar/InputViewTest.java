package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {


    @AfterEach
    void setUp() {
        Console.close();
    }

    @Test
    void 시도_횟수_입력_테스트() {
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("5".getBytes());
        System.setIn(fakeInput);

        String input = InputView.readTryNumber();

        assertThat(input).isNotNull();
    }


    @Test
    void 경기_참여_자동차_입력_테스트() {
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("pobi,junhy,hello".getBytes());
        System.setIn(fakeInput);

        String input = InputView.readCarName();
        String[] inputs = input.split(",");
        for (int i = 0; i < inputs.length; i++) {
            assertThat(inputs[i].length()).isLessThanOrEqualTo(5);
            assertThat(inputs[i]).isNotNull();
        }
    }

    @Test
    void 자동차_입력_검증_테스트() {
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("\n".getBytes());
        System.setIn(fakeInput);

        assertThatThrownBy(() -> InputView.readCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백이 입력되었습니다.");
    }

    @Test
    void 시도_횟수_입력_음수_검증_테스트() {
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("-1".getBytes());
        System.setIn(fakeInput);

        assertThatThrownBy(() -> InputView.readTryNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 음수가 입력되었습니다.");
    }

    @Test
    void 시도_횟수_입력_공백_검증_테스트() {
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("\n".getBytes());
        System.setIn(fakeInput);

        assertThatThrownBy(() -> InputView.readTryNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백이 입력되었습니다.");

    }

    @Test
    void 시도_횟수_입력_ZERO_검증_테스트() {
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("0".getBytes());
        System.setIn(fakeInput);
        assertThatThrownBy(() -> InputView.readTryNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 0이 입력되었습니다.");
    }

    @Test
    void 시도_횟수_입력_INTEGER_검증_테스트() {
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("ABCD".getBytes());
        System.setIn(fakeInput);
        assertThatThrownBy(() -> InputView.readTryNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
    }


}
