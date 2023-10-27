package racingcar.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Rank implements Model{
    private final PriorityQueue<Car> rankQueue;

    Rank(final List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
        rankQueue = new PriorityQueue<>(cars);
    }

    public List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();

        Car winner = requireNonNull(rankQueue.poll());
        winnerList.add(winner.getName());

        while (!rankQueue.isEmpty() && rankQueue.peek().getMoved() == winner.getMoved()) {
            Car tmp = requireNonNull(rankQueue.poll());
            winnerList.add(tmp.getName());
        }

        return winnerList;
    }
}
