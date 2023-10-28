package racingcar.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Count {
    public int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        int count = Integer.parseInt(input);
        return count;
    }
}
