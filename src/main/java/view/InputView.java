package view;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    public String inputCarName(){
        return Console.readLine();
    }

    public int inputTryCount() {
        return Integer.parseInt(Console.readLine());
    }
}
