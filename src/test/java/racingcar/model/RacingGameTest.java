package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import racingcar.service.RacingGameService;


@DisplayName("레이싱 게임 테스트")
class RacingGameTest {

    @Test
    @DisplayName("자동차 이름들 문자열이 들어왔을 경우 해당 문자열을 통해 레이싱에 참여할 자동차 리스트를 생성하며 게임 생성")
    void init_CarNameIsEntered() {
        // given
        String carNameString = "beom,sic,test";

        // when
        RacingGameService racingGameService = RacingGameService.from(carNameString);

        // then
        List<Car> racingCarList = racingGameService.getRacingCarList();
        assertAll(
                () -> assertThat(racingCarList).isNotEmpty(),
                () ->  assertThat(racingCarList).hasSize(3)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " , ", "   ", " , , "})
    void init_EmptyCarNameIsEntered_ThrownException() {
        // given
        // when

        // then
        assertThatThrownBy(() -> RacingGameService.from("")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("inputCarNamesForPlayTest")
    @DisplayName("Racing Game play시 레이싱 게임에 참여하는 모든 자동차가 움직이거나 정지한 결과인 Result를 return 한다.")
    void play_AllCarsHaveMovedOrStopped(String inputNameString, int count, String[] names) {
        // given
        RacingGameService racingGameService = RacingGameService.from(inputNameString);

        // when
        List<Result> results = racingGameService.play();

        List<String> resultNames = results.stream()
                .map(Result::name)
                .toList();

        // then
        assertAll(
                () -> assertThat(results).isNotEmpty(),
                () -> assertThat(results).hasSize(count),
                () -> assertThat(resultNames).containsExactlyInAnyOrder(names)
        );
    }

    @ParameterizedTest
    @MethodSource("inputCarNamesForDetermineWinnersTest")
    @DisplayName("레이싱 게임이 진행된 후 결과를 제대로 계산하는지 테스트")
    void determineRaceWinners(String inputNameString, int[] randoms,
                              int expectedWinnerCount, String[] expectedWinners) {
        // given
        RacingGameService racingGameService = RacingGameService.from(inputNameString);
        MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);

        // when
        when(Randoms.pickNumberInRange(0, 9)).thenAnswer(new Answer<Integer>() {
            private int callCount = 0;
            @Override
            public Integer answer(InvocationOnMock invocation) {
                return randoms[callCount++];
            }
        });
        racingGameService.play();
        List<String> winners = racingGameService.determineRaceWinners();

        // then
        assertAll(
                () -> assertThat(winners).isNotEmpty(),
                () -> assertThat(winners).hasSize(expectedWinnerCount),
                () -> assertThat(winners).contains(expectedWinners)
        );
        mockRandoms.close();
    }

    private static Stream<Arguments> inputCarNamesForPlayTest() {
        return Stream.of(
                Arguments.of("beom,pobi,woni", 3, new String[] {"beom", "pobi", "woni"}),
                Arguments.of("beom,pobi,woni,jun", 4, new String[] {"beom", "pobi", "woni", "jun"}),
                Arguments.of("beom", 1, new String[] {"beom"})
        );
    }

    private static Stream<Arguments> inputCarNamesForDetermineWinnersTest() {
        return Stream.of(
                Arguments.of("beom,pobi,woni", new int[] {1, 2, 5}, 1, new String[] {"woni"}),
                Arguments.of("beom,pobi,woni,jun", new int[] {3, 5, 2, 9}, 2, new String[] {"pobi", "jun"}),
                Arguments.of("beom,pobi", new int[] {1, 4}, 1, new String[] {"pobi"})
        );
    }
}
