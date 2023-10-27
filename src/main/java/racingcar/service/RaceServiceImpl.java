package racingcar.service;

import racingcar.domain.participant.Participant;
import racingcar.domain.participant.ParticipantFactory;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.parser.CarNameParser;
import racingcar.util.validator.CarNameValidator;
import racingcar.util.validator.RaceCountValidator;

import java.util.ArrayList;
import java.util.List;

public class RaceServiceImpl implements RaceService {
    public RaceServiceImpl(
            CarNameValidator carNameValidator,
            RaceCountValidator raceCountValidator,
            CarNameParser carNameParser,
            ParticipantFactory participantFactory,
            RandomNumberGenerator randomNumberGenerator
    ) {
        this.carNameValidator = carNameValidator;
        this.raceCountValidator = raceCountValidator;
        this.carNameParser = carNameParser;
        this.participantFactory = participantFactory;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    private final CarNameValidator carNameValidator;
    private final RaceCountValidator raceCountValidator;
    private final CarNameParser carNameParser;
    private final ParticipantFactory participantFactory;
    private final RandomNumberGenerator randomNumberGenerator;

    private final int STANDARD_VALUE = 4;

    @Override
    public void validateCarName(String input) {
        for ( String carName : carNameParser.parse(input) ) {
            if ( !carNameValidator.validate(carName) )
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void validateRaceCount(String input) {
        if (!raceCountValidator.validate(input))
            throw new IllegalArgumentException();
    }

    @Override
    public List<Participant> parseToParticipantList(String input) {
        List<Participant> participants = new ArrayList<>();

        for (String carName : carNameParser.parse(input)) {
            participants.add(participantFactory.getParticipant(carName));
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
    public List<Participant> filterWinner(List<Participant> participants) {
        int maxDistance = participants.stream()
                .map(Participant::getDistance)
                .max(Integer::compareTo)
                .orElse(0);
        return participants.stream().filter(p -> p.getDistance() == maxDistance).toList();
    }
}
