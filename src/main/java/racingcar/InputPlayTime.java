package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputPlayTime {
    public static int inputPlayTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        IllegalException.illegalException(input);
        return Integer.parseInt(input);
    }
}