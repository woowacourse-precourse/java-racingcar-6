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
            List<Car> result = inputProcessor.manipulateCarNameInput(input);

            //then
            assertThat(result).hasSize(3)
                    .contains(Car.of("aaa"))
                    .contains(Car.of("bbb"))
                    .contains(Car.of("ccc"));
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
}