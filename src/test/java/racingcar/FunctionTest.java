package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarListPutInMap;
import racingcar.domain.ForwardCarCondition;
import racingcar.domain.PrintRacingRankStatus;
import racingcar.domain.RacingValue;
import racingcar.domain.Referee;

public class FunctionTest {
    @Test
    @DisplayName("우승자가 여러 명일 때 우승자 모두를 출력하는가?")
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
    @DisplayName("이동 여부를 결정하는 숫자가 4 이상일 때만 전진하는가?")
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
    @DisplayName("각 자동차의 이동횟수를 알맞게 출력하는가?")
    void 각_자동차의_이동횟수를_알맞게_출력하는가() {
        PrintRacingRankStatus printRacingRankStatus = new PrintRacingRankStatus();
        LinkedHashMap<String, Integer> racingStatus = new LinkedHashMap<>() {{
            put("qwer", 1);
            put("asdf", 2);
            put("zxcv", 3);
        }};

        printRacingRankStatus.printRacingCar(racingStatus);
    }
}
