package racingcar.dto.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constants.Condition.NAME_SIZE;
import static racingcar.constants.ErrorMessage.LENGTH_LIMIT;
import static racingcar.constants.Format.WINNER_DELIMITER;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarNamesDtoTest {
    @Test
    void 경주차이름의_길이제한을_넘길때_예외발생시키기() {
        // given
        String request = "jongmee,meoru,gari";

        // when & then
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new CarNamesDto(request);
        });
        assertEquals(LENGTH_LIMIT + NAME_SIZE, exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("경주차이름_설정")
    void 공백을_제거하고_경주차이름_입력받기(String request, List<String> parsedNames) {
        // given & when
        CarNamesDto carNamesDto = new CarNamesDto(request);

        // then
        assertThat(carNamesDto.getNames()).containsAll(parsedNames);
    }

    private static Stream<Arguments> 경주차이름_설정() {
        return Stream.of(
            Arguments.arguments("zzol, jong, meoru", List.of("zzol", "jong", "meoru")),
            Arguments.arguments("  zzol,     jong ,  meoru ", List.of("zzol", "jong", "meoru"))
        );
    }
}