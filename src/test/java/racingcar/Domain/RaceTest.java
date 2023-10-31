package racingcar.Domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class RaceTest {

    @Test
    @DisplayName("입력받은 수만큼 경주를 진행했다면 True")
    void givenRaceOrder_thenReturnTrue() {
        // given
        int userRaceCount = 4;
        Race testRace = new Race(userRaceCount);

        // when
        boolean isRaceFinish = testRace.isRaceOver(userRaceCount);

        // then
        assertThat(isRaceFinish)
                .isTrue();
    }

    @Test
    @DisplayName("입력받은 수만큼 경주를 진행하지 않았다면 False 리턴")
    void givenRaceOrder_thenReturnFalse() {
        // given
        int userRaceCount = 4;
        Race testRace = new Race(userRaceCount);
        int raceCount = 2;

        // when
        boolean isRaceFinish = testRace.isRaceOver(raceCount);

        // then
        assertThat(isRaceFinish)
                .isFalse();
    }
}