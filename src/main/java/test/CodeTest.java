package test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CodeTest {
    @Test
    void 입력된_자동차이름들_분리(){
        String input = "abc,def,123,가나다";
        String[] result = input.split(",");

        assertThat(result).contains("abc", "def", "123", "가나다");
        assertThat(result).containsExactly("abc", "def", "123", "가나다");
    }
    @Test
    void 입력된_값중_자리수가5이상이_있는지_체크(){
        String[] result = {"abc", "def", "123","12345"};
        for(String s : result){
            assertThatThrownBy(() -> s.charAt(5))
                    .isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: 5");
        }
    }

}
