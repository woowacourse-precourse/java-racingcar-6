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
    Formatter formatter = new Formatter();

    @Test
    void formatListStringToString_메서드_정상적인_입력() {
        List<String> inputList = Arrays.asList(CAR_NAME_1, CAR_NAME_2, CAR_NAME_3);
        String expectedResult = CAR_NAME_1
                + COMMA
                + CAR_NAME_2
                + COMMA
                + CAR_NAME_3;
        String result = formatter.formatListStringToString(inputList);
        assertEquals(expectedResult, result);
    }

    @Test
    void formatListStringToString_메서드_null_입력() {
        assertThrows(NullPointerException.class, () -> formatter.formatListStringToString(null));
    }

    @Test
    void formatStringToListString_메서드_정상적인_입력() {
        String inputString = CAR_NAME_1 + COMMA + CAR_NAME_2 + COMMA + CAR_NAME_3;
        List<String> expectedResult = Arrays.asList(CAR_NAME_1, CAR_NAME_2, CAR_NAME_3);
        List<String> result = formatter.formatStringToListString(inputString);
        assertEquals(expectedResult, result);
    }

    @Test
    void formatStringToListString_메서드_null_입력() {
        assertThrows(NullPointerException.class, () -> formatter.formatStringToListString(null));
    }
}
