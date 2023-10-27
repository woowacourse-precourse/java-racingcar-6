package racingcar.domain.participant;

public class ParticipantFactoryImpl implements ParticipantFactory {
    @Override
    public Participant getParticipant(String carName) {
        return new Participant(carName);
    }
}
