package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.ForwardCarCondition;
import racingcar.domain.PrintRacingRankStatus;
import racingcar.domain.RacingValue;
import racingcar.domain.Referee;

public class FunctionTest {
    @Test
    void 입력한_경주_자동차_이름이_모두_MAP에_들어갔는가() {

    }

    @Test
    void 우승자가_여러_명일_때_우승자_모두를_출력하는가() {
        RacingValue racingValue = new RacingValue();
        Referee referee = new Referee();
        LinkedHashMap<String, Integer> racingResult = new LinkedHashMap<>() {{
            put("qwer", 3);
            put("asdf", 2);
            put("zxcv", 3);
        }};

        racingValue.racingStatus = racingResult;
        String winnerCars = referee.callWinnerCar();

        assertThat(winnerCars).contains("qwer", "zxcv");
    }

    @Test
    void 이동_여부를_결정하는_숫자가_4_이상일_때만_전진하는가() {
        ForwardCarCondition forwardCarCondition = new ForwardCarCondition();
        List<Integer> forwardRandomNumber = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        forwardRandomNumber.forEach(randomValue -> {
            if (randomValue >= 4) {
                assertEquals(forwardCarCondition.forwardControl(randomValue), 1);
            } else if (randomValue < 4) {
                assertEquals(forwardCarCondition.forwardControl(randomValue), 0);
            }
        });

    }

    @Test
    void 경주를_반복할_때마다_각_자동차의_이동횟수를_알맞게_출력하는가() {
        PrintRacingRankStatus printRacingRankStatus = new PrintRacingRankStatus();
        LinkedHashMap<String, Integer> racingStatus = new LinkedHashMap<>() {{
            put("qwer", 1);
            put("asdf", 2);
            put("zxcv", 3);
        }};

        printRacingRankStatus.printRacingCar(racingStatus);
    }
}
