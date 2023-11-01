package racingcar.v1;

import camp.nextstep.edu.missionutils.Console;

/**
 * F1 - 44 ~ 78 Lap Round -> Lap
 */
public class RacingRoundV1 {
    public int attemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());
        return attemptCount;
    }


}
