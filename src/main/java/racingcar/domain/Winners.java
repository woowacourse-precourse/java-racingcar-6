package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private static final String FINAL_WINNERS = "최종 우승자 : ";
    private static final String FINAL_WINNERS_DELIMITER = ", ";
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
