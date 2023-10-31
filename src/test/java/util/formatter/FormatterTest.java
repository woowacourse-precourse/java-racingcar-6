package util.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static resource.TestData.CAR_NAME_1;
import static resource.TestData.CAR_NAME_2;
import static resource.TestData.CAR_NAME_3;
import static resource.TestData.COMMA;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FormatterTest {
    @Test
    void formatListStringToString_메서드_정상적인_입력() {
        Formatter formatter = new Formatter();
        List<String> inputList = Arrays.asList(CAR_NAME_1, CAR_NAME_2, CAR_NAME_3);
        String sb = CAR_NAME_1
                + ","
                + CAR_NAME_2
                + ","
                + CAR_NAME_3;
        String result = formatter.formatListStringToString(inputList);
        assertEquals(sb, result);
    }

    @Test
    void formatListStringToString_메서드_null_입력() {
        Formatter formatter = new Formatter();
        List<String> inputList = null;
        assertThrows(NullPointerException.class, () -> formatter.formatListStringToString(inputList));
    }

    @Test
    void formatStringToListString_메서드_정상적인_입력() {
        Formatter formatter = new Formatter();
        String inputString = CAR_NAME_1 + COMMA + CAR_NAME_2 + COMMA + CAR_NAME_3;
        List<String> expectedResult = Arrays.asList(CAR_NAME_1, CAR_NAME_2, CAR_NAME_3);
        List<String> result = formatter.formatStringToListString(inputString);
        assertEquals(expectedResult, result);
    }

    @Test
    void formatStringToListString_메서드_null_입력() {
        Formatter formatter = new Formatter();
        String inputString = null;
        assertThrows(NullPointerException.class, () -> formatter.formatStringToListString(inputString));
    }
}
