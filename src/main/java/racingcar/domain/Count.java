package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Count {
    public int usercount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int count = Integer.parseInt(input);
        if (count < 1) throw new IllegalArgumentException();
        return count;
    }
}