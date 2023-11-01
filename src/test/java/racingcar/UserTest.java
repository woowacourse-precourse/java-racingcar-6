package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;

class UserTest {
    //    @Test
//    void testInput() {
//        //given
//
//        //when
//
//        //then
//    }

    @Test
    void inputCarNames_자동차이름을_정확히_반환() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("car1,car2,car3");
            List<String> carNames = User.inputCarNames();
            assertThat(carNames).containsExactly("car1", "car2", "car3");
        }
    }

    @Test
    void inputMoveCount_시도회수를_정확히_반환() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("10");
            int moveCount = User.inputMoveCount();
            assertThat(moveCount).isEqualTo(10);
        }
    }

    @Test
    void splitInput_메소드로_주어진_값을_구분() {
        String input = "pobi,woni,jun";
        List<String> result = User.splitInput(input);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void stringToInteger_MoveCount의_값을_int로_변환() {
        String input = "1234";
        int result = User.stringToInteger(input);
        assertThat(result).isEqualTo(1234);
    }

    @Test
    void isNull_입력값이_없을_때_예외_처리() {
        assertThatThrownBy(() -> User.isNull(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 없습니다.");
    }

    @Test
    void stringToInteger_MoveCount의_값이_String일_때_예외_처리() {
        String input = "jieun";
        assertThatThrownBy(() -> User.stringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자가 아닌 숫자를 입력해 주세요.");
    }

    @Test
    void isZero_MoveCount의_값이_0일_때_예외_처리() {
        int input = 0;
        assertThatThrownBy(() -> User.isZero(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력회수는 0이 아닌 수를 입력해 주세요.");
    }
}