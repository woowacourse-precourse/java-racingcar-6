package util;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CYCLE_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printCycleInputMessage() {
        System.out.println(CYCLE_INPUT_MESSAGE);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String input() {
        return Console.readLine();
    }

}
