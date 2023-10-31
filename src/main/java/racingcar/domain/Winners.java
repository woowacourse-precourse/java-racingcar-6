package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.domain.constants.Constants.FINAL_WINNERS;
import static racingcar.domain.constants.Constants.FINAL_WINNERS_DELIMITER;

public class Winners {

    private List<Position> positions;
    private int tryCnt;

    private Winners(List<Position> positions, int tryCnt) {
        this.positions = positions;
        this.tryCnt = tryCnt;
    }

    public static Winners createWinners(List<Position> positions, int tryCnt) {
        return new Winners(positions, tryCnt);
    }

    public void printWinners() {
        List<Position> winningPositions = findWinningPositions();
        String winnersList = createWinnersList(winningPositions);
        System.out.print(FINAL_WINNERS + winnersList);
    }

    private List<Position> findWinningPositions() {
        return positions.stream()
                .filter(position -> position.distanceValue() == tryCnt)
                .collect(Collectors.toList());
    }

    private String createWinnersList(List<Position> winningPositions) {
        return winningPositions.stream()
                .map(Position::carInfo)
                .collect(Collectors.joining(FINAL_WINNERS_DELIMITER));
    }
}
