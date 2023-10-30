package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingValue;
import racingcar.domain.Referee;

public class FunctionTest {
    @Test
    void 우승자가_여러_명일_때_쉼표를_이용하여_구분_후_출력하는가() {

        // given (이런 값이 들어왔을 때)
        RacingValue racingValue = new RacingValue();
        Referee referee = new Referee();
        Map<String, Integer> racingResult = new HashMap<>() {{
            put("qwer", 3);
            put("asdf", 2);
            put("zxcv", 3);
        }};

        // when (이렇게 실행되면)
        racingValue.racingStatus = racingResult;
        String winnerCars = referee.callWinnerCar();

        // then (이렇게 나와야 함)
        assertThat(winnerCars).contains("qwer, zxcv");
    }
}
