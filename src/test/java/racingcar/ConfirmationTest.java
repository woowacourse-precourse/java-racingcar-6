package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.handler.UserInputHandler;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConfirmationTest {
    private final UserInputHandler userInputHandler = new UserInputHandler();

    @Test
    void 자동차이름_5자초과_예외_처리() {
        String nameList = "iamdabin";

        assertThatThrownBy(() -> userInputHandler.validateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }
}

