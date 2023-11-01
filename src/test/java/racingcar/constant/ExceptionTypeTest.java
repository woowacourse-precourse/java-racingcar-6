package racingcar.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class ExceptionTypeTest {
    @Test
    void 예외_메세지_테스트() {
        String nameExceptionMsg = "이름 형식이 잘못된 것 같아요. 공백이 포함되지 않은 1글자 이상 5글자 이내의 문자열을 입력해 주세요.";
        String numberExceptionMsg = "횟수 입력이 잘못된 것 같아요. 이동 횟수는 자연수로만 이루어져야 해요.";
        assertAll(
                () -> assertThat(ExceptionType.NAME.message()).isEqualTo(nameExceptionMsg),
                () -> assertThat(ExceptionType.NUMBER.message()).isEqualTo(numberExceptionMsg));
    }
}
