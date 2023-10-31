package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

class Reader {
    Reader() {
    }

    String readLine() {
        try {
            return Console.readLine();
        } catch (Exception ex) {
            throw new IllegalArgumentException();
        }
    }
}
