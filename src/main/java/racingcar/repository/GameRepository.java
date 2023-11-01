package racingcar.repository;

import java.util.HashMap;
import java.util.Map;

import racingcar.domain.Game;

public class GameRepository {
    private long id = 0L;
    private final Map<Long, Game> games = new HashMap<>();
    //게임의 시행 차수 마다 저장
    public long save(Game game) {
        long returnId = id;
        games.put(id, game);
        id += 1;
        return returnId;
    }
    //최종 시행 횟수에 도달 했는지 확인
    public boolean isEnd(Game game) {
        return game.checkReach_TrialNumber();
    }

}