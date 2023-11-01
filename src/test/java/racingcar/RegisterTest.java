package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Register;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RegisterTest {

    Register register = new Register();

    @Test
    void checkCarNameTest(){
        assertThatThrownBy(() -> register.checkCarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
