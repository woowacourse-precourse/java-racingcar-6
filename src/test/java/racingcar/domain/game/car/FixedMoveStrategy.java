package racingcar.domain.game.car;

import racingcar.move.MoveStrategy;

class FixedMoveStrategy implements MoveStrategy {
    private final boolean isPlaying;

    public FixedMoveStrategy(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    @Override
    public boolean isMovable() {
        return isPlaying;
    }
}