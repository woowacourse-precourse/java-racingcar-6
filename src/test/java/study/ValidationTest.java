package study;

import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Validation;


public class ValidationTest {

    @Test
    void name_0자미만_6자이상_array입력() {
        ArrayList<String> input = new ArrayList<>(Arrays.asList("안녕하세요", "아아아아", "kimsssss"));
        Assertions.assertThatThrownBy(() -> Validation.validateLengthOfName(input))
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

