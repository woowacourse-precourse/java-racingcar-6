package racingcar.ui;

import racingcar.RacingGameComponent;

public interface UserInputReader<T extends RacingGameComponent> {

    public T readPureNumber() throws IllegalArgumentException;

    public T readPureWords() throws IllegalArgumentException;

    public void close();
}
