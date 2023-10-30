package racingcar.domain.cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class WinnersTest {

    static final int MOVE_VALUE = 5;
    static final int DONT_MOVE_VALUE = 1;

    @Test
    @DisplayName("정적 메소드 judge()에 Players를 입력하면 우승자를 판단해 Winners를 반환한다.")
    void returnWinners_whenCallStaticMethodJudgeWithPlayer() {
        // given
        List<String> names = Arrays.asList("tae", "wan");
        Players players = new Players(names);

        MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class);
        mockedRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
            .thenReturn(MOVE_VALUE, DONT_MOVE_VALUE);

        players.moveAll();

        // when
        Winners winners = Winners.judge(players);

        // then
        assertThat(winners.toString()).isEqualTo("최종 우승자 : tae");

        mockedRandoms.close();
    }

    @Test
    @DisplayName("toString() 이 최종 우승자를 담은 문자열을 반환한다.")
    void toStringReturnFinalWinners() {
        // given
        List<String> names = Arrays.asList("tae", "wan");
        Players players = new Players(names);

        MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class);
        mockedRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
            .thenReturn(DONT_MOVE_VALUE, MOVE_VALUE);

        players.moveAll();
        players.moveAll();

        Winners winners = Winners.judge(players);

        // when
        String message = winners.toString();

        // then
        assertThat(message).isEqualTo("최종 우승자 : wan");

        mockedRandoms.close();
    }
}