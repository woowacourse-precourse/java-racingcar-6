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
    @DisplayName("레이싱에 참여할 자동차 리스트를 생성하며 게임 생성")
    void init_CarNameIsEntered() {
        // given
        String carNameString = "pobi,test,fsm12";
        // when
        RacingGameService racingGameService = RacingGameService.make(carNameString);
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
        assertThatThrownBy(() -> RacingGameService.make("")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("inputCarNamesForPlayTest")
    @DisplayName("레이싱 게임에 참여한 모든 차량의 결과 테스트")
    void play_AllCarsHaveMovedOrStopped(String inputNameString, int count, String[] names) {
        // given
        RacingGameService racingGameService = RacingGameService.make(inputNameString);
        // when
        List<CarStatus> carStatuses = racingGameService.play();
        List<String> resultNames = carStatuses.stream()
                .map(CarStatus::name)
                .toList();
        // then
        assertAll(
                () -> assertThat(carStatuses).isNotEmpty(),
                () -> assertThat(carStatuses).hasSize(count),
                () -> assertThat(resultNames).containsExactlyInAnyOrder(names)
        );
    }

    @ParameterizedTest
    @MethodSource("WinnersDetermineTest")
    @DisplayName("레이싱 결과 테스트")
    void determineRaceWinners(String inputNameString, int[] randoms,
                              int expectedWinnerCount, String[] expectedWinners) {
        // given
        RacingGameService racingGameService = RacingGameService.make(inputNameString);
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
        List<String> winners = racingGameService.getRaceWinners();
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
                Arguments.of("pobi,woni,fsm12", 3, new String[] {"pobi", "woni", "fsm12"}),
                Arguments.of("pobi,woni,jun,fsm12", 4, new String[] {"pobi", "woni", "jun", "fsm12"}),
                Arguments.of("fsm12", 1, new String[] {"fsm12"})
        );
    }

    private static Stream<Arguments> WinnersDetermineTest() {
        return Stream.of(
                Arguments.of("pobi,woni,fsm12", new int[] {1, 2, 5}, 1, new String[] {"fsm12"}),
                Arguments.of("pobi,woni,jun,fsm12", new int[] {3, 5, 2, 9}, 2, new String[] {"woni", "fsm12"}),
                Arguments.of("pobi,woni", new int[] {1, 4}, 1, new String[] {"woni"})
        );
    }
}
