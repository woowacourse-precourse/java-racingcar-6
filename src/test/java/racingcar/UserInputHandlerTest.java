package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInputHandlerTest {
    UserInputHandler userInputHandler;

    @BeforeEach
    void setUp() {
        userInputHandler = new UserInputHandler();
    }
    
    @Test
    void 이름_5자_이상시_오류() {
        assertThatThrownBy(() -> {
            userInputHandler.getCarsInput("testeff");
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 이름_길이_0일시_오류() {
        assertThatThrownBy(() -> {
            userInputHandler.getCarsInput("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}