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

    @Test
    void 무작위수_비교(){
        boolean result;

        for(int i = 0; i < 10; i++) {
            result = test.check_num(i);
            if(i < 4) {
                assertThat(result).isFalse();
            }
            else {
                assertThat(result).isTrue();
            }
        }
    }
}
