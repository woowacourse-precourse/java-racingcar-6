package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingAttemptInput {

    public void requestAttemptCount() {
        System.out.println("시도할 횟수는 몇회인가요? ");
    }

    public String readUserInput() {
        return Console.readLine();
    }

    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    public int getAttemptCount() {
        String input = readUserInput();
        return convertToInteger(input);
    }

}
