package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.GamePlayer;

public class GameServiceTest extends NsTest {

    @Test
    public void 자동차_이름으로_자동차와_플레이어_생성() {
        //given
        List<String> names = new ArrayList(Arrays.asList("name1", "name2", "name3"));
        GameService gameService = new GameService();
        //when
        GamePlayer gamePlayer = gameService.initializePlayer(names);
        gamePlayer.moveCarsByCount(1);
        //then
        assertThat(output()).contains("name1", "name2", "name3");
        assertThat(output()).doesNotContain("name4");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
