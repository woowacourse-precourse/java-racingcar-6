package racingcar.service;

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

    @Test
    public void 자동차_이름으로_자동차와_플레이어_생성() {
        //given
        List<String> names = new ArrayList(Arrays.asList("name1", "name2", "name3"));
        GameService gameService = new GameService();

        //when
        GamePlayer gamePlayer = GamePlayer.from(CarNames.from(names));
        gameService.moveCarsByCount(gamePlayer, new MoveCount(MOVE_COUNT));

        //then
        assertThat(output()).contains("name1", "name2", "name3");
        assertThat(output()).doesNotContain("name4");
    }
//  랜덤값을 어떻게 테스트할건지 생각해보기
//    @Test
//    public void 모든_자동차_지정된_횟수만큼_랜덤으로_이동() {
//        //given
//
//        //when
//
//        //then
//
//    }

    @Test
    public void 플레이어_정보로_게임등수_생성() {
        //given
        List<String> names = new ArrayList(Arrays.asList("name1", "name2", "name3"));
        GameService gameService = new GameService();
        //when
        GamePlayer gamePlayer = GamePlayer.from(CarNames.from(names));
        gameService.moveCarsByCount(gamePlayer, new MoveCount(MOVE_COUNT));
        //then
        assertThat(output()).contains("name1", "name2", "name3");
        assertThat(output()).doesNotContain("name4");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
