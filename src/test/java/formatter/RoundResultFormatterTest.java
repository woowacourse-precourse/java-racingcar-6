package formatter;

import util.formatter.RoundResultFormatter;
import dto.RoundResultDto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RoundResultFormatterTest {

    @ParameterizedTest
    @DisplayName("List<RoundResultDto>를 문자열로 올바르게 포맷하는지 테스트")
    @MethodSource("provideRoundResultDtoAndExpectData")
    public void formatTest(List<RoundResultDto> dtos, String expected) {
        // When
        String result = RoundResultFormatter.format(dtos);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRoundResultDtoAndExpectData() {
        return Stream.of(
                createTestCase(
                        Arrays.asList("pobi", "woni", "jun"),
                        Arrays.asList(3, 1, 0),
                        "pobi : ---\n",
                        "woni : -\n",
                        "jun : \n"
                ),
                createTestCase(
                        Arrays.asList("tom", "jerry", "hoon"),
                        Arrays.asList(2, 4, 5),
                        "tom : --\n",
                        "jerry : ----\n",
                        "hoon : -----\n"
                )
        );
    }

    private static Arguments createTestCase(List<String> names, List<Integer> locations,
            String... expectedLines) {
        List<RoundResultDto> dtos = createRoundResultDtos(names, locations);
        String expected = buildExpectedString(expectedLines);
        return Arguments.of(dtos, expected);
    }

    private static String buildExpectedString(String... lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line);
        }
        return builder.toString();
    }

    private static List<RoundResultDto> createRoundResultDtos(List<String> names,
            List<Integer> locations) {
        return IntStream.range(0, names.size())
                .mapToObj(i -> new RoundResultDto(names.get(i), locations.get(i)))
                .collect(Collectors.toList());
    }
}