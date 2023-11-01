package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class SetRound {
    public static int setRound() {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            Integer num = Integer.valueOf(Console.readLine());
            if (num <= 0) {
                throw new IllegalArgumentException("양수인 값을 입력해야 합니다.");
            }
                return num;
        }
    }
}
