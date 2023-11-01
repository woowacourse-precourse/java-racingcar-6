package racingcar.repository;

import racingcar.domain.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRepository {
    private long nextGameId = 0L;
    private final Map<Long, Game> gameMap = new HashMap<>();

    // 게임 저장
    public long saveGame(Game game) {
        Long returnId = nextGameId;
        gameMap.put(nextGameId, game);
        nextGameId += 1;
        return returnId;
    }


    // 게임 종료 여부 확인
    public boolean isGameFinished(Game game) {
        return game.isGameFinished();
    }

    // ID로 게임 찾기
    public Game findGameById(long id) {
        return gameMap.get(id);
    }

    // 모든 게임 목록 반환
    public List<Game> findAllGames() {
        return new ArrayList<>(gameMap.values());
    }
}
