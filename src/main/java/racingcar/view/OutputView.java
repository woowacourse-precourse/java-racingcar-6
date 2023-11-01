package racingcar.view;

import java.util.Map;

public class OutputView {
    private final static String RESULT_MESSAGE = "실행 결과";
    private final static String DISTANCE_MARK = "-";
    private final static String EQUAL_MARK = " : ";
    private final static String WINNER_MESSAGE = "최종 우승자 : ";

    public static void gameResultStart(){
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public static void gameResult(Map<String, Integer> cars){
        cars.forEach((name, distance) -> System.out.println(name + EQUAL_MARK + convertDistanceMark(distance)));
        System.out.println();
    }

    private static StringBuilder convertDistanceMark(int distance){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<distance; i++) result.append(DISTANCE_MARK);
        return result;
    }

    public static void winnerView(String winner){
        System.out.println(WINNER_MESSAGE + winner);
    }
}
