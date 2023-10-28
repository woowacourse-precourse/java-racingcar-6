package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RaceWinners {
    private final List<String> winners;

    private RaceWinners(RaceParticipants raceParticipants) {
    }

    public static RaceWinners from(RaceParticipants raceParticipants) {
        return new RaceWinners(raceParticipants);
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
