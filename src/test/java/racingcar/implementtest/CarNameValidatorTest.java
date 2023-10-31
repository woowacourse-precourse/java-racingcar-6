package racingcar.implementtest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.CarNameValidator;

public class CarNameValidatorTest {
    private CarNameValidator carNameValidator;

    @BeforeEach
    void initTest() {
        carNameValidator = new CarNameValidator();
    }

    @Test
    void 여러빈칸입력() {
        Assertions.assertThatThrownBy(() -> carNameValidator.checkEmptyInput("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸이 입력되었습니다.");

    }

    @Test
    void 빈칸입력() {
        Assertions.assertThatThrownBy(() -> carNameValidator.checkEmptyInput(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸이 입력되었습니다.");

    }

    @Test
    void 무입력() {
        Assertions.assertThatThrownBy(() -> carNameValidator.checkEmptyInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸이 입력되었습니다.");

    }

    @Test
    void 쉼표로_시작한_경우() {
        Assertions.assertThatThrownBy(() -> carNameValidator.checkInvalidSeparator(",name,name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(",으로 시작할 수 없습니다.");

    }

    @Test
    void 쉼표로_끝나는_경우() {
        Assertions.assertThatThrownBy(() -> carNameValidator.checkInvalidSeparator("name,name,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(",으로 끝날 수 없습니다.");
    }

    @Test
    void 쉼표를_연속으로_사용한_경우() {
        Assertions.assertThatThrownBy(() -> carNameValidator.checkInvalidSeparator("name,,,name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표를 연속으로 사용하였습니다.");
    }

    @Test
    void 이름이_5자_이상일_경우() {
        Assertions.assertThatThrownBy(() -> carNameValidator.checkNameLength("longName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 이름이_공백으로_시작한_경우() {
        Assertions.assertThatThrownBy(() -> carNameValidator.checkNameBlankStart(" name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 공백으로 시작하면 안됩니다.");
    }

    @Test
    void 이름이_공백으로_끝난_경우() {
        Assertions.assertThatThrownBy(() -> carNameValidator.checkNameBlankEnd("name "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 공백으로 끝나면 안됩니다.");
    }

    @Test
    void 중복된_이름이_있는_경우() {
        carNameValidator.checkNameDuplicate("name");
        Assertions.assertThatThrownBy(() -> carNameValidator.checkNameDuplicate("name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 입력되었습니다.");
    }
}
