package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Console;
import org.mockito.MockedStatic;

class InputViewTest {

    InputView inputView = new InputView();
    private static MockedStatic<Console> consoleMock;

    @BeforeEach
    void BeforeSetUp() {
        consoleMock = mockStatic(Console.class);
    }

    @AfterEach
    void AfterSetUp() {
        consoleMock.close();
    }

    @DisplayName("자동차 이름 입력 테스트")
    @Test
    void testInputCarNames() {
        when(Console.readLine()).thenReturn("car A, car B, car C");
        List<String> carNames = inputView.inputCarNames();

        assertEquals(List.of("car A", "car B", "car C"), carNames);
    }

    @Nested
    @DisplayName("경주에는 두 대 이상의 자동차가 참여해야 한다.")
    class testValidateCarInput {
        @Test
        void 경주에_한대의_자동차가_참여할수_없다() {
            assertThrows(IllegalArgumentException.class, () -> inputView.validateCarInput("car1-car2-car3"));
        }

        @Test
        void 경주에_0대의_자동차가_참여할수_없다() {
            assertThrows(IllegalArgumentException.class, () -> inputView.validateCarInput(""));
        }

        @Test
        void 경주에_두대_이상의_자동차가_참여할수_있다() {
            assertDoesNotThrow(()->inputView.validateCarInput("car1, car2"));
        }
    }

    @Nested
    @DisplayName("시도(이동) 횟수 입력은 숫자여야 한다.")
    class testInputAttempNum {
        @Test
        void 시도_횟수가_숫자가_아닐시_오류가_발생한다() {
            when(Console.readLine()).thenReturn("not-digit");
            assertThrows(IllegalArgumentException.class, ()->inputView.inputAttemptNumber());
        }

        @Test
        void 시도_횟수가_숫자일시_테스트에_성공한다() {
            when(Console.readLine()).thenReturn("1");
            assertDoesNotThrow(()->inputView.inputAttemptNumber());
        }
    }
}