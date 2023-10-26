package racingcar;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.GameController;

public class GameControllerTest {
    @Nested
    class 사용자로부터_받은_자동차_이름들 {

        private GameController gameController;

        @BeforeEach
        void init() {
            gameController = new GameController();
        }

        @AfterEach
        void close() {
            Console.close();
        }

        @ParameterizedTest
        @ValueSource(strings = {"\n", " ", "abc,abc", "abc"})
        void 공백이나_중복된_이름_2개_미만의_이름을_입력하면_예외를_던진다(String input) {
            byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            assertThatIllegalArgumentException().isThrownBy(() -> gameController.start());
        }
    }
}
