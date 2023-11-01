package racingcar.domain.cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.domain.car.Car;

class WinnersTest {

    static final int MOVE_VALUE = 5;
    static final int DONT_MOVE_VALUE = 1;

    @Test
    @DisplayName("정적 메소드 judge()에 Players를 입력하면 우승자를 판단해 Winners를 반환한다.")
    void returnWinners_whenCallStaticMethodJudgeWithPlayer() {
        // given
        List<String> names = Arrays.asList("tae", "wan");
        Players players = Players.of(names);

        MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class);
        mockedRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
            .thenReturn(MOVE_VALUE, DONT_MOVE_VALUE);

        players.moveAll();

        // when
        Winners winners = Winners.judge(players);

        // then
        assertThat(
            winners.cars().stream()
                .map(Car::name)
                .collect(Collectors.toList())
        ).contains("tae");

        mockedRandoms.close();
    }
}