package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static racingcar.constant.GameResultMessageConstant.PROGRESSIVE_BAR;
import static racingcar.constant.GameResultMessageConstant.WINNER_RESULT;

public class ViewMaker {
    public ViewMaker() {
    }

    public String makeCurrentPositionView(String name, int position) {
        return name + " : " +
                PROGRESSIVE_BAR.repeat(Math.max(0, position)) + "\n";
    }

    public String makeWinnerView(List<String> winners) {
        return WINNER_RESULT + String.join(", ", winners);
    }
}
