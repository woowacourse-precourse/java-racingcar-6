package racingcar.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CarRank implements Model {
    private final PriorityQueue<Car> rankQueue;

    CarRank(final List<Car> cars) {
        rankQueue = new PriorityQueue<>(cars);
    }

    /**
     * 가장 멀리 간 자동차의 이름(name)과 더불어 같은 거리만큼 움직인 자동차의 이름을 모은 리스트를 반환하는 메서드
     *
     * @return 우승자들의 이름 문자열 리스트
     */
    public List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();

        Car winner = requireNonNull(rankQueue.poll());
        winnerList.add(winner.getName());

        while (!rankQueue.isEmpty() && isTieRecord(winner)) {
            Car nextCar = requireNonNull(rankQueue.poll());
            winnerList.add(nextCar.getName());
        }

        return winnerList;
    }

    private boolean isTieRecord(final Car winner) {
        Car candidate = requireNonNull(rankQueue.peek());
        return winner.isDraw(candidate);
    }
}
