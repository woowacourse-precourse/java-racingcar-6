package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final String WINNER = "최종 우승자 : ";

    private static final String MOVE_MARK = "-";


    public static void outputResultMessage(){
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public static void outputCarAndScore(String name, int score){
        System.out.print(name + " : ");
        for(int i=0; i<score; i++){
            System.out.print(MOVE_MARK);
        }
        System.out.println();
    }

    public static void outputWinner(List<String> winner){
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER);
        for(String name : winner){
            sb.append(name).append(", ");
        }
        sb.delete(sb.length()-2,sb.length()-1);
        System.out.println(sb);
    }
}
