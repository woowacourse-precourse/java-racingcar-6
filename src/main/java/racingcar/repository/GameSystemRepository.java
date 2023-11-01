package racingcar.repository;


import racingcar.domain.GameSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameSystemRepository {
    private static final Map<Long, GameSystem> store = new HashMap<>();
    private static long id=0L;

    public GameSystem save(GameSystem gameSystem){
        store.put(id++,gameSystem);
        return gameSystem;
    }

    public Boolean checkComplete(GameSystem gameSystem) {
        return gameSystem.compareAttemptNumToFinal();
    }

}
