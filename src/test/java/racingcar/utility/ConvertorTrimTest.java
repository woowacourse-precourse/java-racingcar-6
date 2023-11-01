package racingcar.utility;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertorTrimTest {

    @Test
    @DisplayName("List<String>에 대한 trim을 성공적으로 수행한다.")
    void trimSuccessTest() {
        // given
        List<String> strings = List.of("  가나다", "라마    ", "  바사아  ");

        // when
        List<String> result = Convertor.trimStrings(strings);
        List<String> expectedResult = List.of("가나다", "라마", "바사아");

        // then
        Assertions.assertEquals(result, expectedResult);
    }

}
