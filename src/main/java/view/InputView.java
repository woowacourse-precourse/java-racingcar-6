package view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputRacingCarName() {
        return Console.readLine();
    }
    public static String inputNumberOfMatch() {
        return Console.readLine(); //model에서 int로 변환할 것
    }
}
