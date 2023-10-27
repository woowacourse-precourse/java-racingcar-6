package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
public class CarNamesInputView {

    public static String input() {
        InputMessageView.CarNamesInput();
        return Console.readLine();
    }
}
