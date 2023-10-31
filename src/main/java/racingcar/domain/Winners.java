package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private static final String COMMA_AND_BLANK = ", ";

    private final List<Winner> winners;

    public Winners(List<Winner> winnerList) {
        winners = winnerList;
    }

    public String makeWinnerList() {
        return winners.stream()
                .map(Winner::toString)
                .collect(Collectors.joining(COMMA_AND_BLANK));
    }
}
