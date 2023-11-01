package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayTimeTest {

    @DisplayName("최소 횟수")
    @Test
    void minimumPlayTest() {
        //given
        String testNumber = "0";
        //when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> PlayTime.isValid(testNumber));
    }

    @DisplayName("숫자가 아닌 값")
    @Test
    void integerTypeTest() {
        //given
        String testNonNumeric = "a";
        //when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> PlayTime.isValid(testNonNumeric));
    }

    @DisplayName("빈 값")
    @Test
    void emptyPlayTimeTest() {
        //given
        String emptyValue = "";
        //when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> PlayTime.isValid(emptyValue));
    }
}