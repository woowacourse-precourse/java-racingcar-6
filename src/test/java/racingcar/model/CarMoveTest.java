package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import racingcar.constant.GameMessage;
import racingcar.domain.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("자동차 레이스 이동 테스트")
class CarMoveTest {

    @DisplayName("전진 확인")
    @Test
    void 전진_확인() {
        // given
        Cars cars = new Cars(Arrays.asList(new Car("car1"), new Car("car2")));
        MoveCnt moveCnt = new MoveCnt("2");
        List<Integer> rand1 = Arrays.asList(GameMessage.GO_MIN_VALUE, GameMessage.GO_MIN_VALUE + 1);
        List<Integer> rand2 = Arrays.asList(GameMessage.GO_MIN_VALUE + 2, GameMessage.GO_MIN_VALUE + 3);
        List<List<Integer>> randNum = Arrays.asList(rand1, rand2);

        // when
        AllRaceRecords allRecords = getRaceResult(cars, moveCnt, randNum);

        // then
        assertThat(allRecords.getAllRecords().get(0).getRaceResult()).isEqualTo(Arrays.asList(1, 2));
        assertThat(allRecords.getAllRecords().get(1).getRaceResult()).isEqualTo(Arrays.asList(1, 2));
    }

    @DisplayName("제자리 확인")
    @Test
    void 제자리_확인() {
        // given
        Cars cars = new Cars(Arrays.asList(new Car("car1"), new Car("car2")));
        MoveCnt moveCnt = new MoveCnt("2");
        List<Integer> rand1 = Arrays.asList(GameMessage.GO_MIN_VALUE - 1, GameMessage.GO_MIN_VALUE - 2);
        List<Integer> rand2 = Arrays.asList(GameMessage.GO_MIN_VALUE - 3, GameMessage.GO_MIN_VALUE - 4);
        List<List<Integer>> randNum = Arrays.asList(rand1, rand2);

        // when
        AllRaceRecords allRecords = getRaceResult(cars, moveCnt, randNum);

        // then
        assertThat(allRecords.getAllRecords().get(0).getRaceResult()).isEqualTo(Arrays.asList(0, 0));
        assertThat(allRecords.getAllRecords().get(1).getRaceResult()).isEqualTo(Arrays.asList(0, 0));
    }

    // 랜덤값을 직접 생성해서 테스트하기 위해 메서드 내용 복사해서 일부 수정
    private AllRaceRecords getRaceResult(Cars cars, MoveCnt moveCnt, List<List<Integer>> randNum) {
        List<RaceRecord> allRecords = new ArrayList<>();

        int i = 0;
        for (Car car : cars) {
            allRecords.add(getEachCarRaceResult(car, moveCnt, randNum.get(i++)));
        }

        return new AllRaceRecords(allRecords);
    }

    private RaceRecord getEachCarRaceResult(Car car, MoveCnt moveCnt, List<Integer> randNum) {
        List<Integer> raceResult = new ArrayList<>();

        int dist = 0;
        for (int i = 0; i < moveCnt.getMoveCnt(); i++) {
            boolean go = decideGo(randNum.get(i));  // 난수 생성해서 해당 자동차의 이동 여부 결정
            String carName = car.getName();

            if (go) {
                dist++;
            }
            raceResult.add(dist);
        }
        return new RaceRecord(car, raceResult);
    }

    // 앞으로 이동 여부 결정하는 메서드
    private boolean decideGo(int digit) {
        if (digit >= GameMessage.GO_MIN_VALUE) {
            return true;
        }
        return false;
    }

}