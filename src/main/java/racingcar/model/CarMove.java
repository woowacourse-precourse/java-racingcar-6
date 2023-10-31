package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameMessage;
import racingcar.domain.*;

import java.util.*;

public class CarMove {
    // 자동차별 레이스 결과를 모두 담은 리스트를 반환하는 메서드
    public AllRaceRecords getRaceResult(Cars cars, MoveCnt moveCnt) {
        List<RaceRecord> allRecords = new ArrayList<>();

        for (Car car : cars) {
            allRecords.add(getEachCarRaceResult(car, moveCnt));
        }

        return new AllRaceRecords(allRecords);
    }

    // 각 자동차별 전체 레이스의 위치 변화 반환하는 메서드
    private RaceRecord getEachCarRaceResult(Car car, MoveCnt moveCnt) {
        List<Integer> raceResult = new ArrayList<>();

        int dist = 0;
        for (int i = 0; i < moveCnt.getMoveCnt(); i++) {
            boolean go = decideGo(pickRandNum());  // 난수 생성해서 해당 자동차의 이동 여부 결정
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

    private int pickRandNum() {
        return Randoms.pickNumberInRange(GameMessage.GO_RAND_NUM_MIN_SIZE,
                GameMessage.GO_RAND_NUM_MAX_SIZE);
    }


}
