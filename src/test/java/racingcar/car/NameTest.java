package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Name;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("문자열이 공백인 경우, 이름 생성에 실패한다.")
    void createName_StringName_ThrowIllegalArgumentException() {
        String name = "";
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("문자열의 길이가 5보다 크다면, 이름 생성에 실패한다.")
    void createName_StringName2_ThrowIllegalArgumentException() {
        String name = "가나다라마바사";
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 1자 이상, 5자 이하여야 합니다.");
    }

}
