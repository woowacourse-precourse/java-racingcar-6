package racingcar.Service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserInputTest {
    @DisplayName("사용자가 입력")
    @Test
    void 자동차_이름에_대한_예외_출력테스트() {
        //when
        UserInput userInput = new UserInput();
        assertThatThrownBy(() -> {
            userInput.userInputCarName();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }


}