package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConverterTest {
    @Test
    void stringToIntConverterSuccess() {
        //given
        String s = "5";

        //when
        int stringToInt = Converter.stringToInt(s);

        //then
        Assertions.assertEquals(5,stringToInt);
    }

    @Test
    void stringToIntConverterFail() {
        //given
        String s = "a";

        //when
        //then
        assertThatThrownBy(() -> Converter.stringToInt(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.IS_NOT_NUMBER.getMessage());
    }

    @Test
    void stringToListConverter() {
        //given
        String s = "aaa,bbb,ccc";

        //when
        List<String> stringToList = Converter.stringToList(s);

        //then
        Assertions.assertEquals("aaa", stringToList.get(0));
        Assertions.assertEquals("bbb", stringToList.get(1));
        Assertions.assertEquals("ccc", stringToList.get(2));
    }
}
