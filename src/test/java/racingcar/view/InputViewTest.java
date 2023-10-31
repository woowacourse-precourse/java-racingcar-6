package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @BeforeEach
    void setUp() {
        Console.close(); // Scanner 초기화
    }

    @Test
    void 자동차_이름_입력값_확인() {
        // Given
        String input = "pobi,crong,honux";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // When
        String carNames = InputView.carInput();

        // Then
        assertThat(carNames).isEqualTo(input);
    }

    @Test
    void 시도_회수_입력값_확인() {
        // Given
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // When
        int retryCount = Integer.parseInt(InputView.tryCountInput());

        // Then
        assertThat(retryCount).isEqualTo(5);
    }
}
