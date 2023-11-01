package racingcar.controller;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.type.TrialCount;
import racingcar.domain.RacingCars;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.RoundDTO;
import racingcar.util.TestContext;
import racingcar.util.TestInitializer;

public class GameTest {
    private RacingCars racingCars;

    @BeforeEach
    public void setUp() {
        TestContext context = new TestContext();
        TestInitializer.initializeAll(context);
        racingCars = context.getRacingCars();
    }

    @Test
    public void play_메서드_테스트() {
        // given
        Game game = Game.of(racingCars);
        TrialCount trialCount = TrialCount.of("3");

        // when
        List<AllRoundDTO> allRoundResults = game.play(trialCount);

        // then, 마지막 라운드만 체크
        AllRoundDTO lastRound = allRoundResults.get(allRoundResults.size() - 1);
        List<RoundDTO> roundDTOs = lastRound.roundDTOs();

        // 모든 차가 이동할 수 있으므로 각 차의 거리가 3이어야 함
        for (RoundDTO roundDTO : roundDTOs) {
            Assertions.assertEquals(3, roundDTO.getDistance());
        }
    }
}
