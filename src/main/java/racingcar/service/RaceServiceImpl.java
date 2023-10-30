package racingcar.service;

import racingcar.domain.participant.Participant;
import racingcar.domain.participant.ParticipantFactory;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.parser.NameParser;
import racingcar.util.validator.proxy.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class RaceServiceImpl implements RaceService {
    public RaceServiceImpl(
            InputValidator inputValidator,
            NameParser nameParser,
            ParticipantFactory participantFactory,
            RandomNumberGenerator randomNumberGenerator
    ) {
        this.inputValidator = inputValidator;
        this.nameParser = nameParser;
        this.participantFactory = participantFactory;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    private final InputValidator inputValidator;
    private final NameParser nameParser;
    private final ParticipantFactory participantFactory;
    private final RandomNumberGenerator randomNumberGenerator;

    private final int STANDARD_VALUE = 4;
    private final int DEFAULT_MAX_DISTANCE = 0;

    @Override
    public void validateName(String input) {
        for ( String name : nameParser.parse(input) ) {
            if ( !inputValidator.validateName(name) )
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void validateRaceCount(String input) {
        if (!inputValidator.validateRaceCount(input))
            throw new IllegalArgumentException();
    }

    @Override
    public List<Participant> parseToParticipantList(String input) {
        List<Participant> participants = new ArrayList<>();

        for (String Name : nameParser.parse(input)) {
            participants.add(participantFactory.getParticipant(Name));
        }

        return participants;
    }

    @Override
    public void runRace(List<Participant> participants) {
        participants.forEach(p -> {
            if (randomNumberGenerator.generate() >= STANDARD_VALUE)
                p.increaseDistance();
        });
    }

    @Override
    public List<String> filterWinner(List<Participant> participants) {
        int maxDistance = participants.stream()
                .map(Participant::getDistance)
                .max(Integer::compareTo)
                .orElse(DEFAULT_MAX_DISTANCE);
        return participants.stream().filter(p -> p.getDistance() == maxDistance).map(Participant::getName).toList();
    }
}
