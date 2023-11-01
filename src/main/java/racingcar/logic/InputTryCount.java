package racingcar.logic;

import camp.nextstep.edu.missionutils.Console;

public class InputTryCount {

    public int tryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return tryCount;
    }
}
