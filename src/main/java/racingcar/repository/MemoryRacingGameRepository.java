package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.domain.RacingGame;

public class MemoryRacingGameRepository implements RacingGameRepository {

    public static Map<Long, RacingGame> store = new HashMap<>();

    @Override
    public void save(RacingGame racingGame) {
        store.put(racingGame.getId(), racingGame);
    }

    @Override
    public RacingGame findById(Long id) {
        return store.get(id);
    }
}
