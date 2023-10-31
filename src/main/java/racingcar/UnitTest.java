package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UnitTest {
    game test = new game();

    @Test
    void 이름_분리() {
        String name_bundle = "abc,def,ghi";
        String[] names = test.input_name(name_bundle);
        assertThat(names).containsExactly("abc", "def", "ghi");
    }
}
