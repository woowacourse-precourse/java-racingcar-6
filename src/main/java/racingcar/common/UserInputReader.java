package racingcar.common;

import racingcar.underhood.RacingGameComponent;

public interface UserInputReader<T extends RacingGameComponent> {

    public T readPureNumber() throws IllegalArgumentException;

    public T readPureWords() throws IllegalArgumentException;

    public void close();
}
