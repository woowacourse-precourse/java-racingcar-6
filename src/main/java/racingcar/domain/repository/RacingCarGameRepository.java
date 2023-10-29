package racingcar.domain.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import racingcar.domain.entity.RacingCarGame;

public class RacingCarGameRepository {
    private static Long id;
    private static final Map<Long, RacingCarGame> store = new HashMap<>();

    public Optional<RacingCarGame> save(RacingCarGame racingCarGame) {
        store.put(racingCarGame.getId(), racingCarGame);
        return Optional.ofNullable(racingCarGame);
    }

    public Optional<RacingCarGame> findById(Long id) {
        RacingCarGame racingCarGame = store.get(id);
        return Optional.ofNullable(racingCarGame);
    }
}
