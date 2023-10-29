package racingcar.domain.establisher;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.domain.exception.Checker.typeCheck;

public class Establisher {
    public static int setLaps() {
        return typeCheck(Console.readLine());
    }
}
