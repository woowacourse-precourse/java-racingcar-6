package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class RacingCount {
    public final void inputRacingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());
        RacingValue.racingCount = count;
    }
}