package racingcar.domain.race;

import racingcar.domain.participant.Participant;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private Race() {
        this.participants = new ArrayList<>();
        this.raceCount = 0;
    }

    protected Race(List<Participant> participants, int raceCount) {
        this.participants = participants;
        this.raceCount = raceCount;
    }

    private final List<Participant> participants;
    private final int raceCount;

    public List<Participant> getParticipants() {
        return participants;
    }
}
