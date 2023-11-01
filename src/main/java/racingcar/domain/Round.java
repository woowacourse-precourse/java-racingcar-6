package racingcar.domain;

import racingcar.exception.GameAlreadyFinishedException;
import racingcar.exception.InvalidNumberFormatException;
import racingcar.exception.NonPositiveCountException;

public class Round {
    private int count;

    public Round(String count) {
        this.count = validateAndParseCount(count);
    }

    private int validateAndParseCount(String count) {
        try {
            int parsedCount = Integer.parseInt(count);
            if (parsedCount <= 0) {
                throw new NonPositiveCountException();
            }
            return parsedCount;
        } catch (NumberFormatException exception) {
            throw new InvalidNumberFormatException();
        }
    }

    public boolean isFinished() {
        return this.count == 0;
    }

    public int finishOneRound() {
        if (!isFinished()) {
            return this.count--;
        }
        throw new GameAlreadyFinishedException();
    }

    public int getCount() {
        return count;
    }
}
