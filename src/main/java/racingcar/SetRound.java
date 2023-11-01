package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class SetRound {
    public static int setRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        Integer num = Integer.valueOf(Console.readLine());
        return num;
    }
}
