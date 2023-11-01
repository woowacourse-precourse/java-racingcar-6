package racingcar.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertTest {
    @Test
    @DisplayName("stringToListByComma_테스트")
    void stringToListByComma_테스트() {
        String string = new String("pobi,woni,jun");
        List<String> list = Convert.stringToListByComma(string);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo("pobi");
        assertThat(list.get(1)).isEqualTo("woni");
        assertThat(list.get(2)).isEqualTo("jun");
    }

    @Test
    @DisplayName("stringToInteger_테스트")
    void stringToInteger_테스트() {

        String correctString = new String("5");
        String wrongString = new String("qwe");
        Integer correctInteger = Convert.stringToInteger(correctString);

        assertThat(correctInteger).isEqualTo(5);
        assertThatThrownBy(() -> Convert.stringToInteger(wrongString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("stringToInteger_테스트")
    void stringToInteger_음수_테스트() {

        String negative = "-1";
        assertThatThrownBy(() -> Convert.stringToInteger(negative))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
