package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {
    Validation validation = new Validation();

    @DisplayName("자동차명에 대한 통합 검증 테스트")
    @Test
    void validateCarNames() {
    }

    @DisplayName("지정된 구분자가 아닐 경우 에러 반환")
    @Test
    void validateDelimiterType() {
        String input = "cat,dog.cow,eagle";
        String[] carNames = input.split(",", -1);

        assertThatThrownBy(() -> validation.validateDelimiterType(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 쉼표(,)만 사용 가능 합니다.");
    }

    @DisplayName("자동차의 이름이 5자를 넘을 경우 에러 반환 테스트")
    @Test
    void validateNameLengthOver() {
        String input = "cat,dog,cow,turtle,human";
        String[] carNames = input.split(",", -1);

        assertThatThrownBy(() -> validation.validateNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 1 ~ 5자 사이로 지어주세요");
    }

    @DisplayName("자동차의 이름 중 빈칸이 있다면 에러 반환 테스트")
    @Test
    void validateNameLengthLess() {
        String hasEmpty = "cat,,cow,turtle,cat";
        String[] carNames = hasEmpty.split(",", -1);

        assertThatThrownBy(() -> validation.validateNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 1 ~ 5자 사이로 지어주세요");
    }

    @DisplayName("중복된 이름이 있다면 에러 반환")
    @Test
    void validateDuplicateName() {
        String input = "cat,dog,cow,eagle,cow,human";
        String[] carNames = input.split(",", -1);

        assertThatThrownBy(() -> validation.validateDuplicateName(carNames.length, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름은 사용할 수 없습니다.");
    }

    @DisplayName("횟수가 숫자가 아닐 경우 에러 반환")
    @Test
    void validateGameRound() {
        String input = "a2ajw";

        assertThatThrownBy(() -> validation.validateGameRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }
}