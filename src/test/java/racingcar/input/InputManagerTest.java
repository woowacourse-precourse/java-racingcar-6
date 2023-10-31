package racingcar.input;

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

class InputManagerTest {
    private final InputStream systemIn = System.in;
    private InputManager manager;

    @BeforeEach
    public void each() {
        manager = new InputManager();
    }

    @AfterEach
    public void after() {
        Console.close();
    }

    @Test
    @DisplayName("이름 정상 입력시 리스트 반환")
    void 이름_정상_입력() {
        provideInput("pobi,woni,jun");
        assertThat(manager.inputCarNames())
                .isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @Test
    @DisplayName("이름길이 초과시 예외발생")
    void 이름길이_초과시_예외발생() {
        provideInput("pobi,wonidd,jun");
        assertThatThrownBy(() -> manager.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_정상_입력() {
        provideInput("4");
        assertThat(manager.inputAttemptCount())
                .isEqualTo(4);
    }

    @Test
    @DisplayName("시도횟수가 0일 경우, 예외발생")
    void 시도횟수_비정상_입력_case0() {
        provideInput("0");
        assertThatThrownBy(() -> manager.inputAttemptCount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도횟수가 음수일 경우, 예외발생")
    void 시도횟수_비정상_입력_caseMinus() {
        provideInput("-1");
        assertThatThrownBy(() -> manager.inputAttemptCount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    void provideInput(String str) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(str.getBytes());
        System.setIn(testIn);
    }
}