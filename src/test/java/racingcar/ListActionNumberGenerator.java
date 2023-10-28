package racingcar;

import java.util.List;

public class ListActionNumberGenerator implements ActionNumberGenerator {
    private List<Integer> actionNumbers;
    private int sequence = 0;

    public ListActionNumberGenerator(List<Integer> actionNumbers) {
        this.actionNumbers = actionNumbers;
    }

    @Override
    public int generate() {
        return actionNumbers.get(sequence++);
    }
}
