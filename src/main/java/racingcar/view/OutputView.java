package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printGameResult(){
        System.out.println("실행 결과");
    }

    public static void printCarMovement(String string, int number){
        String result = "";

        for (int i = 0; i < number; i++){
            result = result.concat("-");
        }

        System.out.println(string + " : " + result);
    }

    public static void printStringListJoinComma(List<String> listString){
        System.out.println("최종 우승자 : " + String.join(", ", listString));
    }
}