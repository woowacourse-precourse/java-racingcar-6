package racingcar.model;

import java.util.List;

public class Winners {

    private final List<MoveResult> highScores;

    private Winners(final List<MoveResult> highScores) {
        this.highScores = highScores;
    }

    public static Winners from(final List<MoveResult> highScores) {
        return new Winners(highScores);
    }

    public List<String> getNames() {
        return highScores.stream()
                .map(MoveResult::name)
                .toList();
    }
}
