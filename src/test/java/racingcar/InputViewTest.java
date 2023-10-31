package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void 기본_설정_셋팅() {
        UserInputException userInputException = new UserInputException();
        inputView = new InputView(userInputException);
    }

    @Test
    void 자동차들의_이름_입력_받기() {
        String userInput = "Car1,Car2,Car3,Car4,Car5";

        try (MockedStatic<Console> mocked = mockStatic(Console.class)) {
            mocked.when(Console::readLine).thenReturn(userInput);

            List<String> carNames = inputView.getCarName();

            assertThat(carNames).containsExactly("Car1", "Car2", "Car3", "Car4", "Car5");
        }
    }

    @Test
    void 시도_횟수_입력_받기() {
        String userInput = "10";

        try (MockedStatic<Console> mocked = mockStatic(Console.class)) {
            mocked.when(Console::readLine).thenReturn(userInput);

            int attemptCount = inputView.getAttemptCount();

            assertThat(attemptCount).isEqualTo(10);
        }
    }
}
