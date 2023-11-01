package racingcar.utils;

import java.util.List;

public class PrintUtils {
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String SPACE = "";
    private static final String OUTPUT_RESULT = "실행 결과";
    private static final String OUTPUT_WINNER = "최종 우승자 : ";

    public static void print(String message){
        System.out.println(message);
    }
    public static void printInputCarName(){print(INPUT_CAR_MESSAGE);}
    public static void printInputRacingNumber(){print(INPUT_ROUND_MESSAGE);}
    public static void printNewLine(){print(SPACE);}
    public static void printOutputResult(){print(OUTPUT_RESULT);}
    public static void printOutputWinner(List<String> winnerList){
        String message = OUTPUT_WINNER+String.join(",", winnerList);
        print(message);
    }
}
