package racingcar;

import camp.nextstep.edu.missionutils.Console;

public final class Reader {

    private Reader() {
        throw new UnsupportedOperationException();
    }

    public String[] carNames() {
        return Console.readLine().split(",");
    }

}
