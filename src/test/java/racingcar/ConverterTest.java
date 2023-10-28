package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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


}
