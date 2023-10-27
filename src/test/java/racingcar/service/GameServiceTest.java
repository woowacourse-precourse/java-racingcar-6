package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.GamePlayer;

public class GameServiceTest {

    @Test
    public void 자동차_이름으로_자동차와_플레이어_생성() {
        //given

        List<String> names = new ArrayList(Arrays.asList("name1", "name2", "name3"));
        GameService gameService = new GameService();
        //when
        GamePlayer gamePlayer = gameService.settingPlayer(names);
        List<String> allCarNames = gamePlayer.getAllCarNames();

        //then
        Assertions.assertThat(allCarNames.size()).isEqualTo(3);
        Assertions.assertThat(allCarNames.get(0)).isEqualTo(names.get(0));
        Assertions.assertThat(allCarNames.get(1)).isEqualTo(names.get(1));
        Assertions.assertThat(allCarNames.get(2)).isEqualTo(names.get(2));
    }
}
