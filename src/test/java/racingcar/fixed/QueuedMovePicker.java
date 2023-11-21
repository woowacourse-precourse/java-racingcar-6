package racingcar.fixed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import racingcar.domain.move.Move;
import racingcar.domain.move.MovePicker;

public final class QueuedMovePicker implements MovePicker {

    private final Queue<Move> queue;

    public QueuedMovePicker(final Move... queue) {
        final List<Move> moves = Arrays.stream(queue).toList();
        this.queue = new LinkedList<>(moves);
    }

    @Override
    public Move pick() {
        return queue.poll();
    }
}
