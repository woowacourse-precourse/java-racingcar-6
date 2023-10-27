package io.reader;

import camp.nextstep.edu.missionutils.Console;

public class StdReader implements Reader {
    @Override
    public String readLine() {
        return Console.readLine().trim();
    }
}
