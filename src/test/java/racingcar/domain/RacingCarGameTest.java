package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.config.GameConfig;
import racingcar.dto.GameResultDto;
import racingcar.dto.GameSettingDto;
import racingcar.dto.RoundResultDto;
import racingcar.utils.generator.NumberGenerator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarGameTest {

    private RacingCarGame game;
    private final int min = GameConfig.START_OF_RANGE.getValue();
    private final int max = GameConfig.END_OF_RANGE.getValue();

    @BeforeEach
    public void setup() {
    }

    @Test
    public void testPlayRound_MovesWhenNumberIsGreaterThanOrEqualToCondition() {
        game = new RacingCarGame((min, max) -> 4); // 경계값
        game.initialize(new GameSettingDto(Arrays.asList("car1", "car2"), 1));

        RoundResultDto result = game.playRound();

        // 자동차가 움직였는지 검사
        assertTrue(result.getCarStates().get(0).getCarPosition() > 0);
        assertTrue(result.getCarStates().get(1).getCarPosition() > 0);
    }

    @Test
    public void testPlayRound_DoesNotMoveWhenNumberIsLessThanCondition() {
        game = new RacingCarGame((min, max) -> 3); // 경계값 -1
        game.initialize(new GameSettingDto(Arrays.asList("car1", "car2"), 1));

        RoundResultDto result = game.playRound();

        // 자동차가 움직이지 않았는지 검사
        assertTrue(result.getCarStates().get(0).getCarPosition() == 0);
        assertTrue(result.getCarStates().get(1).getCarPosition() == 0);
    }

    @Test
    public void testGetWinners() {
        List<Integer> sequence = Arrays.asList(4, 4, 3, 4, 4, 3);
        Iterator<Integer> sequenceIterator = sequence.iterator();

        NumberGenerator sequenceGenerator = new NumberGenerator() {
            @Override
            public int generate(int startOfRange, int endOfRange) {
                if (sequenceIterator.hasNext()) {
                    return sequenceIterator.next();
                }
                throw new RuntimeException("Sequence exhausted");
            }
        };

        game = new RacingCarGame(sequenceGenerator);
        game.initialize(new GameSettingDto(Arrays.asList("car1", "car2", "car3"), 2));

        game.playRound(); // car1, car2 움직임
        game.playRound(); // car1, car2 움직임

        GameResultDto winners = game.getWinners();

        // car1, car2가 승자인지 확인
        assertEquals(Arrays.asList("car1", "car2"), winners.getWinnerNames());
    }
}
