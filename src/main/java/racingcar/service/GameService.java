package racingcar.service;

public class GameService {
    public GameService() {
    }

    public static GameService getInstance() {
        return GameService.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final GameService INSTANCE = new GameService();
    }
}
