package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;
import org.junit.jupiter.api.*;
import racingcar.domain.numbergenerator.*;

class RacingManagerTest {
    RacingManager racingManager;
    CarNameParser carNameParser = new CarNameParser();
    NumberGenerator successNumberGenerator = new SetNumberGenerator(5);
    NumberGenerator failureNumberGenerator = new SetNumberGenerator(0);
    String successInputName = "a,b,c,d";

    @Test
    void 횟수_입력_검증_테스트() {
        assertThatThrownBy(() -> {
           new RacingManager(carNameParser.parse(successInputName), 0, successNumberGenerator);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new RacingManager(carNameParser.parse(successInputName), -1, successNumberGenerator);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경기_종료_테스트() {
        RacingManager racingManager = new RacingManager(carNameParser.parse(successInputName), 2, successNumberGenerator);

        racingManager.doAttempt();
        assertThat(racingManager.isRaceEnd()).isFalse();
        racingManager.doAttempt();
        assertThat(racingManager.isRaceEnd()).isTrue();
    }

    @Test
    void 차수_결과_테스트1() {
        RacingManager racingManager = new RacingManager(carNameParser.parse(successInputName), 4, successNumberGenerator);

        racingManager.doAttempt();
        Map<String, Integer> attemptResult = new HashMap<>(0);
        attemptResult.put("a", 1);
        attemptResult.put("b", 1);
        attemptResult.put("c", 1);
        attemptResult.put("d", 1);

        assertThat(racingManager.getAttemptResult()).isEqualTo(attemptResult);
    }

    @Test
    void 차수_결과_테스트2() {
        RacingManager racingManager = new RacingManager(carNameParser.parse(successInputName), 4, failureNumberGenerator);

        racingManager.doAttempt();
        Map<String, Integer> attemptResult = new HashMap<>(0);
        attemptResult.put("a", 0);
        attemptResult.put("b", 0);
        attemptResult.put("c", 0);
        attemptResult.put("d", 0);

        assertThat(racingManager.getAttemptResult()).isEqualTo(attemptResult);
    }

    @Test
    void 게임_승자_테스트() {
        RacingManager racingManager = new RacingManager(carNameParser.parse(successInputName), 3, successNumberGenerator);

        racingManager.doAttempt();
        racingManager.doAttempt();
        racingManager.doAttempt();

        List<String> winner = new ArrayList<>(List.of(successInputName.split(",")));

        assertThat(racingManager.getWinners()).isEqualTo(winner);
    }
}
