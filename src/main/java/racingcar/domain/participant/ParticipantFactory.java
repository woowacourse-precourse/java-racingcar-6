package racingcar.domain.participant;

import racingcar.domain.participant.Participant;

public interface ParticipantFactory {
    Participant getParticipant(String Name);
}
