package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class RacingCount {
    public final int inputRacingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
