package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInputTest {
    private UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }

    @Test
    void 자동차_1개_입력() {
        System.setIn(new ByteArrayInputStream("Jeon".getBytes()));
        List<String> result = userInput.carName();
        assertThat(result).isEqualTo(Arrays.asList("Jeon"));
    }

    @Test
    void 자동차_3개_입력() {
        System.setIn(new ByteArrayInputStream("Jeon,Jeong,Won".getBytes()));
        List<String> result = userInput.carName();
        assertThat(result).isEqualTo(Arrays.asList("Jeon", "Jeong", "Won"));
    }

    @Test
    void 자동차_입력_예외() {
        System.setIn(new ByteArrayInputStream("Jeon,Jeong,Won,racingcar".getBytes()));
        assertThatThrownBy(() -> userInput.carName())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_횟수_입력() {
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        int result = userInput.moveNumber();
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 이동_횟수_예외() {
        System.setIn(new ByteArrayInputStream("five".getBytes()));
        assertThatThrownBy(() -> userInput.moveNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }
}