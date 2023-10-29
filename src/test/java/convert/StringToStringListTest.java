package convert;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.convertor.StringToStringListConvertor;

public class StringToStringListTest {

    @ParameterizedTest
    @DisplayName("문자열 문자열 리스트로 변환 검증")
    @MethodSource("provideStringToStringListCases")
    void testConvert(String input, List<String> expected) {
        List<String> result = StringToStringListConvertor.convert(input);
        Assertions.assertThat(expected).isEqualTo(result);
    }

    private static Stream<Arguments> provideStringToStringListCases() {
        return Stream.of(
                Arguments.of("a,b,c", List.of("a", "b", "c")),
                Arguments.of("Test1,Test2,Test3", List.of("Test1", "Test2", "Test3")),
                Arguments.of("1,2,3", List.of("1", "2", "3"))
        );
    }

}
