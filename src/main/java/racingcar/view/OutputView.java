package racingcar.view;
import static racingcar.view.ConstantView.*;

public class OutputView {
    public void printInputCarNameMessage(){
        System.out.println(INPUT_CAR_NAMES.getMessage());
    }
    public void printInputTriesCountMessage(){
        System.out.println(INPUT_TRIES_COUNT);
    }
    public void printResultMessage(){
        System.out.println(RESULT);
    }
    public void printNewLine(){
        System.out.println();
    }
}
