package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarManagerTest {

    @DisplayName("advancedCount가 가장 높은 RacingCar의 이름이 단일 우승자로 반환된다.")
    @Test
    void should_returnRacingCarNameAsSingleWinner_when_maxAdvancedCount() {
        RacingCar racingCarA = new RacingCar("a");
        RacingCar racingCarB = new RacingCar("b");
        RacingCar racingCarC = new RacingCar("c");
        RacingCarList racingCarList = new RacingCarList(List.of(racingCarA, racingCarB, racingCarC));
        RacingCarManager racingCarManager = new RacingCarManager(5, racingCarList);

        racingCarA.increaseCount();

        Assertions.assertThat(racingCarManager.getWinnersName()).containsExactly(racingCarA.getName());
    }

    @DisplayName("advancedCount가 가장 높은 RacingCar의 이름이 다중 우승자로 반환된다.")
    @Test
    void should_returnRacingCarNameAsMultipleWinner_when_maxAdvancedCount() {
        RacingCar racingCarA = new RacingCar("a");
        RacingCar racingCarB = new RacingCar("b");
        RacingCar racingCarC = new RacingCar("c");
        RacingCarList racingCarList = new RacingCarList(List.of(racingCarA, racingCarB, racingCarC));
        RacingCarManager racingCarManager = new RacingCarManager(5, racingCarList);

        racingCarA.increaseCount();
        racingCarB.increaseCount();

        Assertions.assertThat(racingCarManager.getWinnersName())
                .containsExactly(racingCarA.getName(), racingCarB.getName());
    }

    @DisplayName("decreaseNumberOfAttempt를 횟수만큼 호출하면 isNotGameEnd가 false를 반환한다.")
    @Test
    void should_isNotGameEndReturnFalse_when_invokeDecreaseNumberOfAttempt() {
        int numberOfAttempt = 5;
        RacingCarManager racingCarManager = new RacingCarManager(numberOfAttempt, null);

        for (int index = 0; index < numberOfAttempt - 1; index++) {
            racingCarManager.decreaseNumberOfAttempt();
            Assertions.assertThat(racingCarManager.isNotGameEnd()).isTrue();
        }

        racingCarManager.decreaseNumberOfAttempt();
        Assertions.assertThat(racingCarManager.isNotGameEnd()).isFalse();
    }
}
