package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class AttemptsInput {

    public int inputAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();
        return isNumber(userInput);
    }

    public int isNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }

}
