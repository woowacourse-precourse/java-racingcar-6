package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printResultText(){
        System.out.println("실행 결과");
    }

    public static void printResult(String name, String score){
        System.out.println(name +" : " + score);
    }

    public static void printWinner(List<String> winner){
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
