package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class TryNumber {
    public int getTryNubmers() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNubmer = Integer.parseInt(Console.readLine());
        return tryNubmer;
    }
}
