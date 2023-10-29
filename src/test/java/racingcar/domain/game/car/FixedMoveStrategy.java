package racingcar.domain.game.car;

import racingcar.util.MoveStrategy;

class FixedMoveStrategy implements MoveStrategy {
    private final Boolean isPlaying;

    public FixedMoveStrategy(Boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    @Override
    public boolean isMovable() {
        return isPlaying;
    }
}