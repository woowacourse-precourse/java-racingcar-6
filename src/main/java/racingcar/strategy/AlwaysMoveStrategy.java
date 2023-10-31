package racingcar.strategy;

public class AlwaysMoveStrategy implements MoveStrategy {
    private static final AlwaysMoveStrategy instance = new AlwaysMoveStrategy();

    private AlwaysMoveStrategy() {
    }

    public static AlwaysMoveStrategy getInstance() {
        return instance;
    }

    @Override
    public boolean shouldMove() {
        return true;
    }
}
