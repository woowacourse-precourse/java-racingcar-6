package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private final List<String> carNames;
    private final List<Integer> carMoves;
    private final List<String> winners = new ArrayList<>();

    public Referee(List<String> carNames, List<Integer> carMoves) {
        this.carNames = carNames;
        this.carMoves = carMoves;
    }

    public List<String> getWinners() {
        Integer maxMove = this.getMaxMove();

        for (int i = 0; i < this.carNames.size(); i++) {
            boolean isMaxMove = this.carMoves.get(i).equals(maxMove);
            this.addWinnerName(isMaxMove, this.carNames.get(i));
        }

        return this.winners;
    }

    private void addWinnerName(boolean isMaxMove, String carName) {
        if (isMaxMove) {
            this.winners.add(carName);
        }
    }

    private Integer getMaxMove() {
        return this.carMoves.stream().max(Integer::compareTo).orElse(-1);
    }
}
