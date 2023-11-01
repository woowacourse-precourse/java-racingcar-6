package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {
    private static final String validName = "name";
    private static final String overLengthName = "isOverLength";
    private static final String emptyName = "";
    private static final String spaceBarName = "    ";

    @Test
    @DisplayName("::정상적인 이름이 입력될 경우 예외가 발생하지 않는다")
    void testValidName() {
        assertThatCode(() -> new CarName(validName)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("::5자리를 넘어가는 이름이 입력될 경우 예외가 발생한다")
    void testOverLength() {
        assertThatThrownBy(() -> new CarName(overLengthName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 까지만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("::공백이 입력될 경우 예외가 발생한다")
    void testEmpty() {
        assertThatThrownBy(() -> new CarName(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백은 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("::띄어쓰기로만 이루어진 이름이 입력될 경우 예외가 발생한다")
    void testOnlySpaceBar() {
        assertThatThrownBy(() -> new CarName(spaceBarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백은 입력할 수 없습니다.");
    }
}