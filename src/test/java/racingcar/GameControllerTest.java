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

public class GameControllerTest {
    private GameController gameController;

    @BeforeEach
    void init() {
        gameController = new GameController();
    }

    @AfterEach
    void close() {
        Console.close();
    }

    private static Stream<Arguments> nameAndRoundProvider() {
        return Stream.of(
                // 이름
                Arguments.of("\n", "1"), // 이름 공백
                Arguments.of(" ", "1"), // 이름 공백
                Arguments.of("abc", "1"), // 이름 하나
                Arguments.of("abc,abc", "1"), // 이름 중복
                Arguments.of("abcdef", "1") // 이름 5자 초과
        );
    }
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @ParameterizedTest
    @MethodSource("nameAndRoundProvider")
    void 인풋에_잘못된_값이_들어왔을_때_예외_발생(String nameInput, String roundInput) {
        command(nameInput, roundInput);

        assertThatIllegalArgumentException().isThrownBy(() -> gameController.start());
    }
}
