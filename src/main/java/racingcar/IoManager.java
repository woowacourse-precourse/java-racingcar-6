package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class IoManager {

    private final static String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ENTER_ROUND_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private final static String RESULT_MESSAGE = "\n실행 결과";
    private final static String WINNER_MESSAGE = "최종 우승자 : ";

    public static String readLine() {
        return Console.readLine();
    }

    public static void println(String string) {
        System.out.println(string);
    }

    public static void print(String string){
        System.out.print(string);
    }

    public static void printEmptyLine(){
        System.out.println();
    }

    public static void printEnterCarName() {
        System.out.println(ENTER_CAR_NAMES);
    }

    public static void printWinner(List<String> winners){
        System.out.println(WINNER_MESSAGE + String.join(", ", winners));
    }

    public static void printEnterRoundTryCount() {
        System.out.println(ENTER_ROUND_TRY_COUNT);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }
}
