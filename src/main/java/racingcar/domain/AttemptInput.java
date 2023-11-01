package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;


public class AttemptInput {
    public int getNumAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");

        String input = Console.readLine();

        int numAttempts = Integer.parseInt(input);

        return numAttempts;
    }
}
