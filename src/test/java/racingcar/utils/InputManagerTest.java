package racingcar.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class InputManagerTest extends NsTest {
    @Test
    void 시행_입력_예외처리() {
        assertThrowsExactly(IllegalArgumentException.class,() -> {
            run("1a");
            InputManager.INPUT_MOVE_COUNT.input();
        });
    }

    @Test
    @Order(1)
    void 이름_입력_예외처리() {
        assertThrowsExactly(IllegalArgumentException.class,() -> {
            run("김희겸,신예찬,엄성준,김현진ㅇㅇㅇㅇ");
            InputManager.INPUT_NAME.input();
        });
    }

    @Test
    @Order(2)
    void 이름_입력() {
        run("김희겸,신예찬,엄성준,김현진");
        List<String> input = (List<String>) InputManager.INPUT_NAME.input();
        assertThat(input)
                .contains("김희겸","신예찬","엄성준","김현진");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}