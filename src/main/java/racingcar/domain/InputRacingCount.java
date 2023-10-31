package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class InputRacingCount {
    public final void inputRacingCount() {
        RacingValue racingValue = new RacingValue();
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());
        racingValue.racingCount = count;
    }
}
