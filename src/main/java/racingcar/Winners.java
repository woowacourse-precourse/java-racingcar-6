package racingcar;

import java.util.List;

public class Winners {

    private final List<RaceScore> highScores;

    private Winners(final List<RaceScore> highScores) {
        this.highScores = highScores;
    }

    public static Winners from(final List<RaceScore> highScores) {
        return new Winners(highScores);
    }

    public List<String> getNames() {
        return highScores.stream()
                .map(RaceScore::name)
                .toList();
    }
}
