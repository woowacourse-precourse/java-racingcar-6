package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"+4", "ss", "-1", "0"})
    void 라운드_수_입력값_검증_테스트(String input) {
        generateInput(input);
        assertThatThrownBy(InputView::inputRoundNumber)
                .isInstanceOf(IllegalArgumentException.class);

        Console.close();
    }

    private void generateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
