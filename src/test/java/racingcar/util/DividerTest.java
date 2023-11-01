package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DividerTest {
    Divider divider;

    @BeforeEach
    public void beforeEach() {
        divider = new Divider();
    }

    @Test
    void doByComma() {
        //given
        String testString = "abc,def,ghi,jkl";
        ArrayList<String> testArrayList = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jkl"));
        ArrayList<String> resultArrayList = new ArrayList<>();
        //when
        resultArrayList = divider.doByComma(testString);
        //then
        Assertions.assertThat(resultArrayList).isEqualTo(testArrayList);
    }
}