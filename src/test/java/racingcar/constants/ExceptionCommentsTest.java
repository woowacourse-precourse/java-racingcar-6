package racingcar.constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionCommentsTest {

    @Test
    @DisplayName("예외 문구 테스트")
    void ExceptionCommentsTest() {
        assertAll(
                "예외 문구 테스트",
                () -> assertThat(ExceptionComments.INPUT_NULL_VALUE_COMMENT).isEqualTo("NULL 이 입력 되었습니다."),
                () -> assertThat(ExceptionComments.INPUT_EMPTY_VALUE_COMMENT).isEqualTo("빈값 이 입력 되었습니다."),
                () -> assertThat(ExceptionComments.INPUT_VALUE_SIZE_OVER).isEqualTo(
                        "이름의 크기가 " + Config.CAR_NAME_SIZE + "를 초과 하였습니다."),
                () -> assertThat(ExceptionComments.INPUT_TYPE_NON_NUMBER).isEqualTo("숫자가 아닙니다."),
                () -> assertThat(ExceptionComments.INPUT_VALUE_INCORRECT_COMMENT).isEqualTo("잘못된 값이 입력되었습니다."),
                () -> assertThat(ExceptionComments.INPUT_CAR_NAME_DUPLICATED).isEqualTo("중복 자동차 이름이 입력되었습니다.")
        );
    }

}