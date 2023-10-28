package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    public void inputView() {
        inputView = new InputView();
    }

    // Console 객체는 싱글톤 상태입니다.
    @AfterEach
    public void closeConsole() {
        Console.close();
    }

    public abstract class IOTest {
        protected void systemIn(String input) {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
        }
    }

    @DisplayName("inputCarNames() 선언시 안내문구가 출력되고 입력받는다.")
    @Nested
    class InputTest extends IOTest {

        @DisplayName("입력은 공백을 허용하지 않는다. 공백이 포함되어 있을 경우 IllegalArgumentException 가 발생한다. ")
        @Test
        void noPermitBlank() {

            //given
            inputView();
            systemIn("12 34");

            //then
            Assertions.assertThatThrownBy(() -> inputView.inputCarNames())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("아무것도 입력하지 않고 개행했을 경우 IllegalArgumentException 가 발생한다.")
        @Test
        void noPermitEmpty() {

            //given
            inputView();
            systemIn("\n");

            //then
            Assertions.assertThatThrownBy(() -> inputView.inputCarNames())
                    .isInstanceOf(IllegalArgumentException.class);
        }


        @DisplayName("공백을 포함하지 않는 자동차 이름을 입력할 경우 정상적으로 입력된 이름을 반환합니다.")
        @Test
        void askCarName() {

            //given
            inputView();
            systemIn("pobi,woni,jun");

            //then
            Assertions.assertThat(inputView.inputCarNames()).isEqualTo("pobi,woni,jun");
        }
    }
}
