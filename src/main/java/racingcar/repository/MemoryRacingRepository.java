package racingcar.repository;

import java.util.Optional;
import racingcar.domain.Racing;
import racingcar.domain.Winners;
import racingcar.validation.OptionalValidator;

public class MemoryRacingRepository extends MemoryRepository<Racing> implements RacingRepository {

    @Override
    public Racing updateWinners(Long racingId, Winners winners) {
        Racing racing = findByIdAndWrapOptional(racingId);
        racing.setWinners(winners);

        return racing;
    }

    private Racing findByIdAndWrapOptional(Long racingId) {
        Optional<Racing> optionalRacing = findById(racingId);
        OptionalValidator.validateEmptyOptional(optionalRacing);

        return optionalRacing.get();
    }
}
