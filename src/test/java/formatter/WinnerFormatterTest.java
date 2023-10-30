package formatter;

import dto.WinnerDto;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.formatter.WinnerFormatter;

public class WinnerFormatterTest {

    @ParameterizedTest
    @DisplayName("우승자 출력 형식 포맷 검증")
    @MethodSource("provideWinnerDtoAndExpectValue")
    void formatWinnerDtoTest(WinnerDto winnerDto, String expect) {
        //when
        String result = WinnerFormatter.format(winnerDto);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    public static Stream<Arguments> provideWinnerDtoAndExpectValue() {
        return Stream.of(
                Arguments.of(new WinnerDto(List.of("car1")), "최종 우승자 : car1"),
                Arguments.of(new WinnerDto(List.of("car1", "car2")), "최종 우승자 : car1, car2"),
                Arguments.of(new WinnerDto(List.of("car1", "car2", "car3")), "최종 우승자 : car1, car2, car3")
        );
    }
}
