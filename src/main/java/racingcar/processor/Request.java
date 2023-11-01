package racingcar.processor;

import racingcar.message.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Request {

    public String inputCarName() {
        Console.requestCarName();
        return readLine();
    }

    public int inputGameCount() {
        Console.requestCount();
        return Integer.parseInt(readLine());
    }
}
