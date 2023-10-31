package racingcar.View;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputTest {
    UserInput userInput = new UserInput();
    InputStream sysInBackup;
    String input;

    @BeforeEach
    void 콘솔_입력_받기() {
        sysInBackup = System.in;
    }

    @AfterEach
    void 콘솔_초기화() {
        System.setIn(sysInBackup);
        Console.close();
    }

    @DisplayName("자동차_이름을_리스트로_반환")
    @Test
    void 자동차_이름을_리스트로_반환() {
        input = "jun,woo";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> result = userInput.carName();

        assertThat(result).contains("woo", "jun");
        assertThat(result).containsExactly("jun", "woo");

    }

    @DisplayName("자동차_이름이_5글자를_넘어감")
    @Test
    void 자동차_이름이_5글자를_넘어감() {
        input = "junwoo,woo";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> userInput.carName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하여야 합니다.");
    }

    @DisplayName("게임횟수를_정수로_반환")
    @Test
    void 게임횟수를_정수로_반환() {
        input = "5";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = userInput.Round();
        assertThat(result).isEqualTo("5");
    }

    @DisplayName("게임횟수_입력값이_숫자가_아님")
    @Test
    void 게임횟수_입력값이_숫자가_아님() {
        input = "삼";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> userInput.Round())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 값의 형식이 숫자가 아닙니다.");

    }
}
