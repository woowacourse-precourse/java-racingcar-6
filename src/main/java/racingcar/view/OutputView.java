package racingcar.view;
import static racingcar.view.ConstantView.*;

public class OutputView {
    public static void printInputCarNameMessage(){
        System.out.println(INPUT_CAR_NAMES.getMessage());
    }
    public static void printInputTriesCountMessage(){
        System.out.println(INPUT_TRIES_COUNT);
    }
    public static void printResultMessage(){
        System.out.println(RESULT);
    }
    public static void printNewLine(){
        System.out.println();
    }
}
