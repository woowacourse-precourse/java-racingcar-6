package racingcar.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CarRank implements Model{
    private final PriorityQueue<Car> rankQueue;

    CarRank(final List<Car> cars) {
        rankQueue = new PriorityQueue<>(cars);
    }

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

    private boolean isTieRecord(Car winner) {
        return winner.isDraw(rankQueue.peek());
    }
}
