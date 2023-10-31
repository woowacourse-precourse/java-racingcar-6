package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String FORWARD_SYMBOL = "-";
    private static final String GAME_RESULT = "실행결과";
    private static final String MVP = "최종 우승자 : ";
    private static final String Comma = ", ";

    public static void printResult(){
        System.out.println("");
        System.out.println(GAME_RESULT);
    }

    public static void printMVP(List<String> mvpList) {
        System.out.println(MVP + String.join(Comma, mvpList));
    }

    public static void carPosition(int forward){
        for(int i = 0; i < forward; i++){
            System.out.print(FORWARD_SYMBOL);
        }
        System.out.println();
    }
    public static void printForward(LinkedHashMap<String, Integer> forwardStateList){
        for(Map.Entry<String, Integer> entry : forwardStateList.entrySet()){
            System.out.print(entry.getKey()+ " : ");
            carPosition(entry.getValue());
        }
    }
}
