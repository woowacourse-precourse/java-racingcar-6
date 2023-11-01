package racingcar.domain;

import java.util.List;

public class GameResult {

    public static final String DELIMITER = ", ";
    private String bunchOfWinner;

    public GameResult(List<Car> bunchOfWinner) {
        this.bunchOfWinner = makeBunchOfWinner(bunchOfWinner);
    }

    private String makeBunchOfWinner(List<Car> winners) {
        StringBuilder builder = new StringBuilder();

        winners.stream()
                .forEach((winner) -> builder.append(winner.getName()).append(DELIMITER));

        return getLastDelimiterRemovedResult(builder);
    }

    private String getLastDelimiterRemovedResult(StringBuilder winnersResult) {
       return winnersResult.substring(0, winnersResult.lastIndexOf(DELIMITER));
    }

    @Override
    public String toString() {
        return "최종 우승자 : " + this.bunchOfWinner;
    }
}