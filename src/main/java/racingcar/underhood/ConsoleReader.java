package racingcar.underhood;

import camp.nextstep.edu.missionutils.Console;
import racingcar.factories.CarRecordFactory;
import racingcar.common.UserInputReader;

public class ConsoleReader
        <T extends RacingGameComponent>
        implements UserInputReader {

    private GameRule rule;

    public ConsoleReader(GameRule rule) {
        this.rule = rule;
    }

    @Override
    public T readPureNumber() throws IllegalArgumentException {
        return (T) new NumberOfRepetitions(rule, Console.readLine().trim());
    }

    @Override
    public T readPureWords() throws IllegalArgumentException {
        String rawInput = Console.readLine();
        String[] tokens = rawInput.split(",");
        return (T) CarRecordFactory.createCarRecord(rule, tokens);
    }

    @Override
    public void close() {
        Console.close();
    }
}
