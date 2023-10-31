package racingcar.utility;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertorSplitTest {

    @Test
    @DisplayName("String을 List<String>으로 성공적으로 분할한다.")
    void splitSuccessTest() {
        // given
        String string = "가나다,라마,바사아";
        String delimiter = ",";

        // when
        List<String> result = Convertor.split(string, delimiter);
        List<String> expectedResult = List.of("가나다","라마","바사아");

        // then
        Assertions.assertEquals(result, expectedResult);
    }

}
