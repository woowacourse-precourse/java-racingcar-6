package racingcar.view;

public class OutputView {

    private static final String PLAY_RESULT_MESSAGE = "실행 결과";

    public static void printPlayResultMessage(){
        print(PLAY_RESULT_MESSAGE);
    }

    private static void print(String message) {
        System.out.println(message);
    }

}
