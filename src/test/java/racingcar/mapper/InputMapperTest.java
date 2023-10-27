package racingcar.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputMapperTest {

    @DisplayName("알 수 없는 값(null)을 이름 목록으로 바꿀 수 없다.")
    @Test
    void checkInputNonNull() {
        assertThatThrownBy(() -> InputMapper.mapToNameList(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 입력값입니다.");
    }

    @DisplayName("구분자로 자동차 이름 리스트를 생성할 수 있다.")
    @Test
    void mapToNameList() {
        List<String> expectedList = List.of("pobi", "lee");

        List<String> result = InputMapper.mapToNameList("pobi,lee");

        assertThat(result).isEqualTo(expectedList);
    }

    @DisplayName("주어진 입력값이 숫자 형식이 아닌 경우, 문자열을 양수로 변환할 수 없다.")
    @Test
    void mapToPositiveNumberWithNonNumberFormat() {
        assertThatThrownBy(() -> InputMapper.mapToPositiveNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }

    @DisplayName("양수가 아닌 경우는 변환할 수 없다.")
    @Test
    void mapToPositiveNumberWithNonPositiveNumber() {
        assertThatThrownBy(() -> InputMapper.mapToPositiveNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력해주세요.");
    }

    @DisplayName("양수 형태의 문자열을 양수로 변환할 수 있다.")
    @Test
    void mapToPositiveNumber() {
        int result = InputMapper.mapToPositiveNumber("123");

        assertThat(result).isEqualTo(123);
    }
}
