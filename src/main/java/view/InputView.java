package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분";
    private static final String INPUT_NUM_OF_ATTEMPT = "시도할 회수는 몇회인가요?";
    public static void printUserInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME);
    }

    public static void printUserInputNumOfAttemptMessage() {
        System.out.println(INPUT_NUM_OF_ATTEMPT);
    }
}
