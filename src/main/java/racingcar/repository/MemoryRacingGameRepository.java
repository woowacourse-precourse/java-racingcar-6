package racingcar.repository;

import java.util.Optional;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;
import racingcar.validation.OptionalValidator;

public class MemoryRacingGameRepository extends MemoryRepository<RacingGame> implements RacingGameRepository {

    @Override
    public RacingGame updateWinners(Long racingId, Winners winners) {
        RacingGame racingGame = findByIdAndWrapOptional(racingId);
        racingGame.setWinners(winners);

        return racingGame;
    }

    private RacingGame findByIdAndWrapOptional(Long racingId) {
        Optional<RacingGame> optionalRacing = findById(racingId);
        OptionalValidator.validateEmptyOptional(optionalRacing);

        return optionalRacing.get();
    }
}
