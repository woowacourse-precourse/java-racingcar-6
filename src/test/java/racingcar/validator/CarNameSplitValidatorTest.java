package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameSplitValidatorTest {
    @Test
    void 여러빈칸입력() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸이 입력되었습니다.");
    }

    @Test
    void 빈칸입력() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸이 입력되었습니다.");

    }

    @Test
    void 아무것도_입력되지_않았을때() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸이 입력되었습니다.");

    }

    @Test
    void 쉼표로_시작한_경우() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate(",name,name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(",으로 시작할 수 없습니다.");

    }

    @Test
    void 쉼표로_끝나는_경우() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate("name,name,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(",으로 끝날 수 없습니다.");
    }

    @Test
    void 쉼표를_연속으로_사용한_경우() {
        Assertions.assertThatThrownBy(() -> CarNameSplitValidator.validate("name,,,name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표를 연속으로 사용하였습니다.");
    }
}
