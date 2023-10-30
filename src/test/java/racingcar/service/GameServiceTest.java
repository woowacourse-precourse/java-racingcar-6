package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.GamePlayer;
import racingcar.dto.CarNames;
import racingcar.dto.MoveCount;

public class GameServiceTest extends NsTest {
    private static final int MOVE_COUNT = 1;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final GameService gameService = new GameService();
    private final List<String> normalNames = new ArrayList(Arrays.asList("name1", "name2", "name3"));


    @Test
    public void 자동차_이름으로_자동차와_플레이어_생성_검증() {
        //given
        String notContainName = "name4";
        //when
        GamePlayer gamePlayer = GamePlayer.from(CarNames.from(normalNames));
        gameService.moveCarsByCount(gamePlayer, new MoveCount(MOVE_COUNT));

        //then
        assertThat(output()).contains(normalNames);
        assertThat(output()).doesNotContain(notContainName);
    }

    @Test
    public void 플레이어_정보로_게임등수_생성_검증() {
        //given
        //when
        GamePlayer gamePlayer = GamePlayer.from(CarNames.from(normalNames));
        gameService.moveCarsByCount(gamePlayer, new MoveCount(MOVE_COUNT));
        //then
        assertThat(output()).contains("name1", "name2", "name3");
        assertThat(output()).doesNotContain("name4");
    }

    @Test
    public void 게임등수로_우승자_생성_검증() {
        //given

        //when

        //then

    }

    @Test
    public void 모든_자동차_지정된_횟수만큼_랜덤으로_이동_검증() {
        //given
        //when
        GamePlayer gamePlayer = GamePlayer.from(CarNames.from(normalNames));
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    gameService.moveCarsByCount(gamePlayer, new MoveCount(3));
                    assertThat(output()).contains("name1 : ---", "name2 : --", "name3 : -");
                },
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
