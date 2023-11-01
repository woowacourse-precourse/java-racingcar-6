package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCarEntity;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayGameServiceTest {
    private final PlayGameService playGameService = new PlayGameService();
    private final Integer MOVE_FOWARD = 5;
    private final Integer NOT_MOVE = 1;

    List<RacingCarEntity> racingCarEntityList =
            List.of(
                    new RacingCarEntity("pobi",0),
                    new RacingCarEntity("woni",0)
            );


    @Test
    void 게임_진행_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    playGameService.playGame(racingCarEntityList, 2);
                    assertThat(racingCarEntityList.get(0).getMoveCount()).isEqualTo(2);
                    assertThat(racingCarEntityList.get(1).getMoveCount()).isEqualTo(0);
                },
                MOVE_FOWARD, NOT_MOVE, MOVE_FOWARD, NOT_MOVE
        );
    }

    @Test
    void 자동차_정상_이동_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    playGameService.tryMoveCars(racingCarEntityList);
                    assertThat(racingCarEntityList.get(0).getMoveCount()).isEqualTo(1);
                    assertThat(racingCarEntityList.get(1).getMoveCount()).isEqualTo(0);
                },
                MOVE_FOWARD, NOT_MOVE
        );
    }



    @Test
    void 자동차_4이상_이동_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    playGameService.tryMoveCars(racingCarEntityList);
                    assertThat(racingCarEntityList.get(0).getMoveCount()).isEqualTo(1);
                    assertThat(racingCarEntityList.get(1).getMoveCount()).isEqualTo(0);
                },
                4,3
        );
    }

}
