package racingcar.domain.race;

import racingcar.domain.participant.Participant;

import java.util.List;

public class RaceFactoryImpl implements RaceFactory {
    @Override
    public Race getRace(List<Participant> participants, int raceCount) {
        return new Race(participants, raceCount);
    }
}
