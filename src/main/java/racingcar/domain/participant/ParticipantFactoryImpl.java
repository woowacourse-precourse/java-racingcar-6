package racingcar.domain.participant;

public class ParticipantFactoryImpl implements ParticipantFactory {
    private final String DEFAULT_NAME = "(undefined)";

    @Override
    public Participant getParticipant(String name) {
        if ( name.isEmpty() ) {
            return new Participant(DEFAULT_NAME);
        }
        return new Participant(name);
    }
}
