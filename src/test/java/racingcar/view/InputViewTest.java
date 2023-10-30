package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RoundCount;
import racingcar.domain.validator.CarNamesValidator;
import racingcar.domain.validator.InputValidator;
import racingcar.domain.validator.RoundNumberValidator;

@DisplayName("입력 테스트")
class InputViewTest {

    private InputView inputView;

    @BeforeEach
    public void setUp() {
        InputValidator<String> roundNumberValidator = new RoundNumberValidator();
        InputValidator<List<String>> carNamesValidator = new CarNamesValidator();
        inputView = new InputView(roundNumberValidator, carNamesValidator);
        Console.close();
    }

    @DisplayName("자동차 이름 입력을 올바르게 처리한다")
    @Test
    void testReadCarNames() throws InterruptedException {

        String input = "pobi,jun,woni\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        List<String> carNames = inputView.readCarNames();
        assertThat(carNames).containsExactly("pobi", "jun", "woni");
    }

    @DisplayName("라운드 횟수 입력을 올바르게 처리한다")
    @Test
    void testReadNumberOfRounds() {
        String input = "5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        RoundCount numberOfRounds = inputView.readNumberOfRounds();
        for (int i = 0; i < 5; i++) {
            assertTrue(numberOfRounds.hasNextRound());
            numberOfRounds.consumeRound();
        }
        assertFalse(numberOfRounds.hasNextRound());
    }
}
