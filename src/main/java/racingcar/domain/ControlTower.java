package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.dto.GameRecordDto;

public class ControlTower {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private static final Map<Integer, List<String>> record = new HashMap<>();

    public GameRecordDto startRacing(List<Car> cars, int roundNumber) {
        for (int round = 1; round <= roundNumber; round++) {
            record.put(round, new ArrayList<>());

            cars.forEach((car) -> {
                car.move(Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX));
                addRecord(car.makeRecord());
            });
        }

        return new GameRecordDto(record, cars);
    }

    private void addRecord(String carRecord) {
        int currentRound = record.size();
        List<String> recordList = record.get(currentRound);

        recordList.add(carRecord);
        record.put(currentRound, recordList);
    }
}