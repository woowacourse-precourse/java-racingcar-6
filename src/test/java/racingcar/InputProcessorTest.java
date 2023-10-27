package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class InputProcessorTest {
    private InputProcessor inputProcessor = new InputProcessor();

    @Nested
    @DisplayName("차 이름 입력 기능 테스트")
    class manipulateCarNameInputTest {
        @Test
        @DisplayName("입력받은 정보를 Car List로 반환한다.")
        void parseTest() {
            //given
            String input = "aaa,bbb,ccc";

            //when
            List<Player> result = inputProcessor.manipulateCarNameInput(input);

            //then
            assertThat(result).hasSize(3)
                    .contains(Player.of("aaa"))
                    .contains(Player.of("bbb"))
                    .contains(Player.of("ccc"));
        }

        @Test
        @DisplayName("길이가 6 이상인 이름이 있을 경우 IllegalArgumentException을 발생시킨다.")
        void componentLengthTest() {
            //given
            String input = "aaaaaa,bbb,ccc";

            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> inputProcessor.manipulateCarNameInput(input));
        }

        @Test
        @DisplayName("잘못된 형태의 구분자가 있는 경우 IllegalArgumentException을 발생시킨다.")
        void inputFormatTest() {
            //given
            String input = "aaaaaa,bbb,ccc";

            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> inputProcessor.manipulateCarNameInput(input));
        }
    }

    @Nested
    @DisplayName("이동 횟수 입력 기능 테스트")
    class manipulateRepetitionInputTest {
        @Test
        @DisplayName("입력받은 정보를 Integer로 반환한다.")
        void parseTest() {
            //given
            String input = "12";

            //when
            Integer result = inputProcessor.manipulateRepetitionInput(input);

            //then
            assertThat(result).isEqualTo(12);
        }

        @Test
        @DisplayName("정수 형태의 입력이 아닌 경우 IllegalArgumentException을 발생시킨다.")
        void componentLengthTest() {
            //given
            String input = "a123";

            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> inputProcessor.manipulateRepetitionInput(input));
        }

        @Test
        @DisplayName("음수를 입력한 경우 IllegalArgumentException을 발생시킨다.")
        void inputFormatTest() {
            //given
            String input = "-123";

            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> inputProcessor.manipulateRepetitionInput(input));
        }
    }
}