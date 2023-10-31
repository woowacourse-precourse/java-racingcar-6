package racingcar.errorCheck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ErrorCheckTest {
    @DisplayName("차 이름 길이 테스트")
    @Test
    void carNameSizeTest() {
        String[] names = {"1", "12", "123456"};
        assertThatThrownBy(() -> ErrorCheck.isCarNameFive(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름 길이가 5이하가 아닙니다");
    }

    @DisplayName("시도할 횟수 테스트")
    @Test
    void tryNumberTest() {
        int tryNumber = 0;
        assertThatThrownBy(() -> ErrorCheck.isZeroValues(tryNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다 1이상의 값을 입력해주세요");
    }

    @DisplayName("시도할 횟수가 정수인지 테스트")
    @Test
    void tryNumberIsAlphaTest() {
        String input = "ab01";
        assertThatThrownBy(() -> ErrorCheck.isTryDigit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다 정수를 입력해주세요");
    }

    @DisplayName("차이름에 공백이 있는지 테스트")
    @Test
    void carNameInSpaceTest() {
        String[] input = {"a", "abc ", "ab cd"};
        assertThatThrownBy(() -> ErrorCheck.isCarsNameInSpace(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다 공백없이 입력해주세요");
    }

    @DisplayName("차이름 중복 테스트")
    @Test
    void DuplicationNameCarTest() {
        String[] input = {"a", "bc", "a"};
        assertThatThrownBy(()-> ErrorCheck.isDuplicationNameCar(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 있습니다");
    }
}
