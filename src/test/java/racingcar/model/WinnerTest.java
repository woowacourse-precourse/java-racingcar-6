package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.AllRaceRecords;
import racingcar.domain.Car;
import racingcar.domain.MoveCnt;
import racingcar.domain.RaceRecord;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("우승자 선택 테스트")
class WinnerTest {

    @DisplayName("최종 우승자 선택 확인")
    @Test
    void 최종_우승자_선택_확인() {
        // given
        RaceRecord record1 = new RaceRecord(new Car("car1"), Arrays.asList(1, 2, 3));
        RaceRecord record2 = new RaceRecord(new Car("car2"), Arrays.asList(1, 1, 1));
        RaceRecord record3 = new RaceRecord(new Car("car3"), Arrays.asList(1, 2, 2));
        AllRaceRecords allRecords = new AllRaceRecords(Arrays.asList(record1, record2, record3));
        Winner winner = new Winner();
        MoveCnt moveCnt = new MoveCnt("3");

        // when
        String winnerCar = winner.selectWinner(allRecords, moveCnt);

        // then
        assertThat(winnerCar).isEqualTo("car1");
    }

    @DisplayName("최종 우승자 여러명 선택 확인")
    @Test
    void 최종_우승자_여러명_선택_확인() {
        // given
        RaceRecord record1 = new RaceRecord(new Car("car1"), Arrays.asList(1, 2, 3));
        RaceRecord record2 = new RaceRecord(new Car("car2"), Arrays.asList(1, 1, 1));
        RaceRecord record3 = new RaceRecord(new Car("car3"), Arrays.asList(1, 2, 3));
        AllRaceRecords allRecords = new AllRaceRecords(Arrays.asList(record1, record2, record3));
        Winner winner = new Winner();
        MoveCnt moveCnt = new MoveCnt("3");

        // when
        String winnerCar = winner.selectWinner(allRecords, moveCnt);

        // then
        assertThat(winnerCar).isEqualTo("car1, car3");
    }

}