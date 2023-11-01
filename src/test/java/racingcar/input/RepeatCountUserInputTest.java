package racingcar.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import racingcar.utils.TestFixtureUtils;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class RepeatCountUserInputTest {

    @Mock
    private ConsoleUserInput consoleUserInput = mock(ConsoleUserInput.class);

    private RepeatCountUserInput repeatCountUserInput;

    @BeforeEach
    void setUp() {
        repeatCountUserInput = new RepeatCountUserInput(consoleUserInput);
    }

    @Test
    @DisplayName("RepeatCountUserInput 객체 생성 여부 테스트")
    void input() {
        //given
        final Integer repeatCount = TestFixtureUtils.generateRandomNumber();
        given(consoleUserInput.input()).willReturn(repeatCount.toString());
        //when
        final Integer result = repeatCountUserInput.input();
        //then
        Assertions.assertThat(result).isEqualTo(repeatCount);
    }

    @Test
    @DisplayName("RepeatCountUserInput 객체 생성 여부 테스트 - 숫자가 아닌 문자열 입력시 예외 발생")
    void input_NonNumber() {
        //given
        final String nonNumber = TestFixtureUtils.generateRandomString(1,4);
        given(consoleUserInput.input()).willReturn(nonNumber);
        //when & then
        Assertions.assertThatThrownBy(() -> repeatCountUserInput.input())
                .isInstanceOf(IllegalArgumentException.class);
    }

}