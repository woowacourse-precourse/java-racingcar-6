package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @DisplayName("사용자는 몇 번의 이동을 할 것인지 입력할 수 있다.")
    @Test
    void inputUserTryCount() throws Exception{
        //given
        String userInput = "3";
        TryCount tryCount = new TryCount(userInput);

        //when //then
        Assertions.assertThat(tryCount.getTryCount()).isEqualTo(3);
    }

    @DisplayName("이동할 횟수는 자연수여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0","qw","!@","-1","은"})
    void isNaturalNumberValidate(String input) throws Exception{
        //given

        //when //then
        Assertions.assertThatThrownBy(() -> new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동할 횟수는 자연수여야 한다.");
    }
}