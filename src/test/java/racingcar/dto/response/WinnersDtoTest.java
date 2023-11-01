package racingcar.dto.response;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constants.Format.WINNER_DELIMITER;
import static racingcar.constants.GameMessage.WINNER_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

class WinnersDtoTest {
    private static Integer id = 0;
    @ParameterizedTest
    @MethodSource("우승자_설정")
    void 우승자_목록을_올바른형식으로_출력하기(List<String> carNames, String message) {
        // given
        List<Car> winners = new ArrayList<>();
        for(String name: carNames) {
            winners.add(경주차_생성하기(name));
        }

        // when
        WinnersDto winnersDto = new WinnersDto(winners);

        // then
        assertEquals(message, winnersDto.createMessage());
    }

    private static Stream<Arguments> 우승자_설정() {
        return Stream.of(
            Arguments.arguments(List.of("jong", "meoru", "gari"), "jong" + WINNER_DELIMITER + "meoru" + WINNER_DELIMITER + "gari"),
            Arguments.arguments(List.of("gari", "meoru"), "gari" + WINNER_DELIMITER + "meoru")
        );
    }

    private Car 경주차_생성하기(String name) {
        Car car = new Car(++id, name);
        return car;
    }
}