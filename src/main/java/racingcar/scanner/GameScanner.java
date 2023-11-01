package racingcar.scanner;

import camp.nextstep.edu.missionutils.Console;

public interface GameScanner<T> {

    T scan();

    static void close() {
        Console.close();
    }
}
