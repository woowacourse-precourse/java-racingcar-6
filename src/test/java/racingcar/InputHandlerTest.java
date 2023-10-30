package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.mockito.Mockito.mockStatic;

class InputHandlerTest {

    @Test
    void 유저로_부터_이름_입력값을_받는_기능() {
        try (MockedStatic<Console> mocked = mockStatic(Console.class)) {
            mocked.when(Console::readLine).thenReturn("car1, car2, car3");

            InputHandler inputHandler = new InputHandler();
            List<String> validCarNames = inputHandler.getValidCarNamesFromUser();

            Assertions.assertThat(validCarNames.size()).isEqualTo(3);
            Assertions.assertThat(validCarNames.get(0)).isEqualTo("car1");
            Assertions.assertThat(validCarNames.get(1)).isEqualTo("car2");
            Assertions.assertThat(validCarNames.get(2)).isEqualTo("car3");
        }
    }

    @Test
    void 유저로_부터_이름_입력값을_받는_기능_예외처리() {
        try(MockedStatic<Console> mocked = mockStatic(Console.class)) {
            mocked.when(Console::readLine).thenReturn(" , ");

            InputHandler inputHandler = new InputHandler();

            Assertions.assertThatThrownBy(inputHandler::getValidCarNamesFromUser)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("충분한 수가 아닙니다. 최소 2개 이상 입력해주세요.");
        }
    }
}
