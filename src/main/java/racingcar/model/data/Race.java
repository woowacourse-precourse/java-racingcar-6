package racingcar.model.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.generator.MovementGenerator;
import racingcar.model.record.MoveCount;

/**
 * 자동차 {@code Car} 모음의 경주 이벤트를 나타낸다.
 */
public class Race {
    private Cars cars;
    private MoveCount moveCount;

    /**
     * 주어진 자동차들과 총 이동 횟수로 경주를 생성한다.
     *
     * @param cars 자동차 경주에 참여하는 자동차들
     * @param moveCount 자동차가 총 움직일 횟수
     */
    public Race(Cars cars, MoveCount moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    /**
     * 제공된 movementGenerator에 의해 자동차들을 움직인다.
     *
     * @param movementGenerator 자동차 움직임을 결정할 값을 생성
     * @return 각각의 이동 후의 순위표
     */
    public List<Map<String, Integer>> startMove(MovementGenerator movementGenerator) {
        List<Map<String, Integer>> results = new ArrayList<>();
        for (int times = 0; times < moveCount.moveCount(); times++) {
            cars.moveCars(movementGenerator);
            results.add(new HashMap<>(cars.getRankingTable()));
        }
        return results;
    }

    /**
     * 마지막 위치에 근거하여 경주의 우승자를 결정한다.
     *
     * @return 우승 자동차의 이름
     */
    public List<String> determineWinners() {
        Map<String, Integer> rankingTable = cars.getRankingTable();

        int maxPosition = Collections.max(rankingTable.values());
        List<String> winners = rankingTable.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return winners;
    }
}
