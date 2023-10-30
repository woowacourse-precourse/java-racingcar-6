package racingcar.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private final static String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)";
    private final static String REPEAT_NUM_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String PLAY_MESSAGE = "실행 결과";
    private final static String RESULT_MESSAGE = "최종 우승자 : ";

    public static void inputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void repeatNumMessage() {
        System.out.println(REPEAT_NUM_MESSAGE);
    }

    public static void playMessage() {
        System.out.println("");
        System.out.println(PLAY_MESSAGE);
    }

    public static void resultMessage(List<String> winners) {
        System.out.print(RESULT_MESSAGE);
        String result = String.join(", ",winners);
        System.out.print(result);
    }

    public static void positionShow(int position){
        for(int i=0; i<position; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void carsStateShow(HashMap<String,Integer> carsState){
        for(Map.Entry<String,Integer> entry: carsState.entrySet()){
            System.out.print(entry.getKey()+" : ");
            positionShow(entry.getValue());
        }
        System.out.println();
    }
}