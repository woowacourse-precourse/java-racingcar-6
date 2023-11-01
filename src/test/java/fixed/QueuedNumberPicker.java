package fixed;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import number.NumberPicker;

public final class QueuedNumberPicker implements NumberPicker {

    private final Deque<Integer> numbers;

    public QueuedNumberPicker(final List<Integer> numbers) {
        this.numbers = new ArrayDeque<>(numbers);
    }

    @Override
    public int pick() {
        return numbers.remove();
    }
}
