package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.FixedCarEngine;
import racingcar.dto.CarDto;
import racingcar.dto.RacingResultDto;
import racingcar.dto.RacingRoundResultDto;
import racingcar.dto.UserCarNameDto;

public class RacingCarServiceTest {

    @DisplayName("RacingCarService 객체를 생성한다.")
    @Test
    void createTest() {
        assertThatCode(() -> new RacingCarService(new FixedCarEngine(true)))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자의 입력으로 레이싱 게임을 초기화한다.")
    @ParameterizedTest
    @MethodSource("provideInitializeRacingGameTest")
    void initializeRacingGameTest(UserCarNameDto userCarNameDto, String attemptCounts) {
        RacingCarService racingCarService = new RacingCarService(new FixedCarEngine(true));
        assertThatCode(() -> racingCarService.initializeRacingGame(userCarNameDto, attemptCounts))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> provideInitializeRacingGameTest() {
        return Stream.of(
                arguments(new UserCarNameDto(List.of("pobi", "woni", "jun")), "3"),
                arguments(new UserCarNameDto(List.of("pobi", "woni")), "2"),
                arguments(new UserCarNameDto(List.of("pobi")), "1")
        );
    }

    @DisplayName("레이싱을 한 회차 시작하여 움직였는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideRaceTestArguments")
    void raceTest(UserCarNameDto userCarNameDto, String attemptCounts) {
        List<String> carNames = userCarNameDto.carNames();
        RacingCarService racingCarService = new RacingCarService(new FixedCarEngine(true));
        racingCarService.initializeRacingGame(userCarNameDto, attemptCounts);
        RacingRoundResultDto racingRoundResultDto = racingCarService.race();
        List<CarDto> carDtos = racingRoundResultDto.carDtos();
        for (int i = 0; i < carNames.size(); i++) {
            assertThat(carDtos.get(i).name()).isEqualTo(carNames.get(i));
            assertThat(carDtos.get(i).position()).isEqualTo(1);
        }
    }

    static Stream<Arguments> provideRaceTestArguments() {
        return Stream.of(
                arguments(new UserCarNameDto(List.of("pobi", "woni", "jun")), "3"),
                arguments(new UserCarNameDto(List.of("pobi", "woni", "jun")), "10")
        );
    }

    @DisplayName("레이싱을 시작해 최종 우승자를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideDetermineWinnersTestArguments")
    void determineWinnersTest(UserCarNameDto userCarNameDto, String attemptCounts, List<String> expectedWinners) {
        RacingCarService racingCarService = new RacingCarService(new FixedCarEngine(true));
        racingCarService.initializeRacingGame(userCarNameDto, attemptCounts);
        racingCarService.race();
        RacingResultDto racingResultDto = racingCarService.determineWinner();
        assertThat(racingResultDto.carNames()).isEqualTo(expectedWinners);
    }

    static Stream<Arguments> provideDetermineWinnersTestArguments() {
        return Stream.of(
                arguments(new UserCarNameDto(List.of("pobi", "woni", "jun")), "3", List.of("pobi", "woni", "jun")),
                arguments(new UserCarNameDto(List.of("pobi", "woni", "jun")), "10", List.of("pobi", "woni", "jun"))
        );
    }
}
