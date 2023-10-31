package racingcar.error;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ErrorTest {
    @Test
    void checkIllegalString_문자열_길이_예외처리() {
        List<String> validTest = Arrays.asList("dong", "hamul", "백두산", "moreThan5");
        assertThatThrownBy(() -> Error.checkIllegalString(validTest)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkIllegalString_문자열_정상_처리() {
        List<String> validTest = Arrays.asList("ERica", "12345", "2.2");
        assertThatCode(() -> Error.checkIllegalString(validTest)).doesNotThrowAnyException();
    }

    @Test
    void checkIllegalString_중복_처리() {
        List<String> validTest = new ArrayList<>(Arrays.asList("KO", "ko", "Ko", "kO"));
        assertThatCode(() -> Error.checkIllegalString(validTest)).doesNotThrowAnyException();

        validTest.add("KO");
        assertThatThrownBy(() -> Error.checkIllegalString(validTest)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 입력되었습니다. 다시 입력해주세요.");
    }

    @Test
    void checkIsNumber_숫자_이외_처리() {
        List<String> validTest1 = Arrays.asList("mol", "3.15");
        List<String> validTest2 = Arrays.asList("123", "1235", "1234");

        for (String vaildTest : validTest1) {
            assertThatThrownBy(() -> Error.checkIsNumber(vaildTest)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자만 입력해주세요.");
        }

        for (String vaildTest : validTest2) {
            assertThatCode(() -> Error.checkIsNumber(vaildTest)).doesNotThrowAnyException();
        }

        System.out.println("COME?");
        String vaildTest3 = "1234567890";
        assertThatThrownBy(() -> Error.checkIsNumber(vaildTest3)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("10억 이하의 숫자만 입력해주세요.");
    }
}
