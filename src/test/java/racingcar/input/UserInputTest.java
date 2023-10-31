package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {
    private UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 정상적인_자동차_이름_입력() {
        System.setIn(createUserInput("car1,car2,car3"));
        assertThat(userInput.getCarNames()).isEqualTo(List.of("car1", "car2", "car3"));
    }

    @Test
    void 잘못된_자동차_이름_입력() {
        System.setIn(createUserInput("car1,car1234,car3"));
        assertThatThrownBy(() -> userInput.getCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상적인_시행_횟수_입력() {
        System.setIn(createUserInput("5"));
        assertThat(userInput.getIterationNumber()).isEqualTo(5);
    }

    @Test
    void 잘못된_시행_횟수_입력() {
        System.setIn(createUserInput("이십 회"));
        assertThatThrownBy(() -> userInput.getIterationNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}