package racingcar;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameControllerTest {
    private GameController gameController;

    @BeforeEach
    void init() {
        gameController = new GameController(
                InputView.consoleInputView(),
                OutputView.consoleOutputView()
        );
    }

    @AfterEach
    void close() {
        Console.close();
    }

    private static Stream<Arguments> ProvideNameAndRound() {
        return Stream.of(
                // 이름
                Arguments.of("\n", "1"), // 1. 이름 공백
                Arguments.of(" ", "1"), // 2. 이름 공백
                Arguments.of("abc", "1"), // 3. 이름 하나
                Arguments.of("abc,abc", "1"), // 4. 이름 중복
                Arguments.of("abcdef", "1"), // 5. 이름 5자 초과
                // 라운드
                Arguments.of("abc,def", "\n"), // 6. 라운드 공백
                Arguments.of("abc,def", " "), // 7. 라운드 공백
                Arguments.of("abc,def", "0"), // 8. 라운드 0
                Arguments.of("abc,def", "abc"), // 9. 라운드 숫자가 아님
                Arguments.of("abc,def", "-1") // 10. 라운드 범위 벗어남
        );
    }
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @ParameterizedTest
    @MethodSource("ProvideNameAndRound")
    void 인풋에_잘못된_값이_들어왔을_때_예외_발생(String nameInput, String roundInput) {
        command(nameInput, roundInput);

        assertThatIllegalArgumentException().isThrownBy(() -> gameController.start());
    }
}
