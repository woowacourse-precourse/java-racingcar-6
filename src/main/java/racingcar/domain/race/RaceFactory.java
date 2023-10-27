package racingcar.domain.race;

import racingcar.domain.participant.Participant;

import java.util.List;

public interface RaceFactory {
    Race getRace(List<Participant> participants, int raceCount);
}
