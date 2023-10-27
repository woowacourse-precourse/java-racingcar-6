package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Validation;


public class ValidationTest {

    @Test
    void name_0자미만_6자이상_array입력() {
        String name = "안녕하세요반갑습니다.";
        Assertions.assertThatThrownBy(() -> Validation.validateLengthOfName(name))
                .isInstanceOf(IllegalArgumentException.class) // 여기서 YourExpectedException을 실제 사용하는 예외로 대체해야 합니다.
                .hasMessageContaining("잘못된 입력입니다."); // 예외 메시지도 필요하다면 지정할 수 있습니다.
    }

    @Test
    void name_숫자가_아닌_값() {
        String s = "k";
        Assertions.assertThatThrownBy(() -> Validation.isNotNumber(s))
                .isInstanceOf(IllegalArgumentException.class) // 여기서 YourExpectedException을 실제 사용하는 예외로 대체해야 합니다.
                .hasMessageContaining("잘못된 입력입니다."); // 예외 메시지도 필요하다면 지정할 수 있습니다.
    }


}

